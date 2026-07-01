package com.armazem.backend.repository;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.TipoMovimento;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class EstoqueMovimentoDAO {

    public List<EstoqueMovimento> findAll() {
        return buscarComJoin("SELECT em.*, p.nome AS p_nome, p.categoria AS p_categoria, p.preco_custo AS p_preco_custo, p.preco_venda AS p_preco_venda FROM estoque_movimento em LEFT JOIN produto p ON em.produto_id = p.id ORDER BY em.id DESC");
    }

    public List<EstoqueMovimento> findTop5() {
        return buscarComJoin("SELECT em.*, p.nome AS p_nome, p.categoria AS p_categoria, p.preco_custo AS p_preco_custo, p.preco_venda AS p_preco_venda FROM estoque_movimento em LEFT JOIN produto p ON em.produto_id = p.id ORDER BY em.id DESC LIMIT 5");
    }

    public List<EstoqueMovimento> findLotesProximosVencimento() {
        return buscarComJoin("SELECT em.*, p.nome AS p_nome, p.categoria AS p_categoria, p.preco_custo AS p_preco_custo, p.preco_venda AS p_preco_venda FROM estoque_movimento em LEFT JOIN produto p ON em.produto_id = p.id WHERE em.tipo = 'ENTRADA' AND em.data_validade IS NOT NULL AND em.data_validade >= CURRENT_DATE() AND em.data_validade <= DATE_ADD(CURRENT_DATE(), INTERVAL 30 DAY) ORDER BY em.data_validade ASC");
    }

    private List<EstoqueMovimento> buscarComJoin(String sql) {
        List<EstoqueMovimento> lista = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                try {
                    lista.add(mapRow(rs));
                } catch (Exception e) {
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public void save(EstoqueMovimento m, Connection conn) throws SQLException {
        String sql = "INSERT INTO estoque_movimento (produto_id, tipo, quantidade, data_validade, lote, motivo, observacao, criado_em) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, m.getProduto().getId());
            stmt.setString(2, m.getTipo().name());
            stmt.setInt(3, m.getQuantidade());
            if (m.getDataValidade() != null) {
                stmt.setDate(4, Date.valueOf(m.getDataValidade()));
            } else {
                stmt.setNull(4, Types.DATE);
            }
            stmt.setString(5, m.getLote());
            stmt.setString(6, m.getMotivo());
            stmt.setString(7, m.getObservacao());
            stmt.setTimestamp(8, Timestamp.valueOf(m.getCriadoEm() != null ? m.getCriadoEm() : LocalDateTime.now()));
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    m.setId(keys.getLong(1));
                }
            }
        }
    }

    public BigDecimal calcularGastoMensal() {
        String sql = "SELECT SUM(em.quantidade * p.preco_custo) FROM estoque_movimento em JOIN produto p ON em.produto_id = p.id WHERE em.tipo = 'ENTRADA' AND MONTH(em.criado_em) = MONTH(CURRENT_DATE()) AND YEAR(em.criado_em) = YEAR(CURRENT_DATE())";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            if (rs.next()) {
                BigDecimal val = rs.getBigDecimal(1);
                return val != null ? val : BigDecimal.ZERO;
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return BigDecimal.ZERO;
    }

    private EstoqueMovimento mapRow(ResultSet rs) throws SQLException {
        EstoqueMovimento m = new EstoqueMovimento();
        m.setId(rs.getLong("id"));

        String tipoStr = rs.getString("tipo");
        m.setTipo(tipoStr != null ? TipoMovimento.valueOf(tipoStr.trim().toUpperCase()) : TipoMovimento.ENTRADA);
        m.setQuantidade(rs.getInt("quantidade"));

        String dataValStr = rs.getString("data_validade");
        if (dataValStr != null && !dataValStr.startsWith("0000")) {
            m.setDataValidade(LocalDate.parse(dataValStr));
        }

        m.setLote(rs.getString("lote"));
        m.setMotivo(rs.getString("motivo"));
        m.setObservacao(rs.getString("observacao"));

        Timestamp ts = rs.getTimestamp("criado_em");
        m.setCriadoEm(ts != null ? ts.toLocalDateTime() : LocalDateTime.now());

        long pid = rs.getLong("produto_id");
        Produto p = new Produto();
        p.setId(pid);
        String pNome = rs.getString("p_nome");
        p.setNome(pNome != null ? pNome : "[Produto Excluído]");
        p.setCategoria(rs.getString("p_categoria"));
        p.setPrecoCusto(rs.getBigDecimal("p_preco_custo"));
        p.setPrecoVenda(rs.getBigDecimal("p_preco_venda"));
        m.setProduto(p);

        return m;
    }
}
