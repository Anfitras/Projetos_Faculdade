package com.armazem.backend.repository;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.Fornecedor;
import com.armazem.backend.model.Produto;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProdutoDAO {

    public List<Produto> findAll() {
        List<Produto> lista = new ArrayList<>();
        String sql = "SELECT p.*, f.id AS f_id, f.nome AS f_nome, f.cnpj AS f_cnpj, f.telefone AS f_telefone, f.email AS f_email, f.endereco AS f_endereco, f.ativo AS f_ativo, f.criado_em AS f_criado_em FROM produto p LEFT JOIN fornecedor f ON p.fornecedor_id = f.id";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(mapRow(rs));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }

    public Optional<Produto> findById(Long id) {
        String sql = "SELECT p.*, f.id AS f_id, f.nome AS f_nome, f.cnpj AS f_cnpj, f.telefone AS f_telefone, f.email AS f_email, f.endereco AS f_endereco, f.ativo AS f_ativo, f.criado_em AS f_criado_em FROM produto p LEFT JOIN fornecedor f ON p.fornecedor_id = f.id WHERE p.id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(mapRow(rs));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }

    public Produto save(Produto p) {
        String sql = "INSERT INTO produto (nome, descricao, codigo_barras, categoria, unidade_medida, preco_custo, preco_venda, estoque_atual, estoque_minimo, validade_dias, fornecedor_id, ativo, criado_em, atualizado_em) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getDescricao());
            stmt.setString(3, p.getCodigoBarras());
            stmt.setString(4, p.getCategoria());
            stmt.setString(5, p.getUnidadeMedida() != null ? p.getUnidadeMedida() : "UN");
            stmt.setBigDecimal(6, p.getPrecoCusto());
            stmt.setBigDecimal(7, p.getPrecoVenda());
            stmt.setInt(8, p.getEstoqueAtual() != null ? p.getEstoqueAtual() : 0);
            stmt.setInt(9, p.getEstoqueMinimo() != null ? p.getEstoqueMinimo() : 5);
            if (p.getValidadeDias() != null) {
                stmt.setInt(10, p.getValidadeDias());
            } else {
                stmt.setNull(10, Types.INTEGER);
            }
            if (p.getFornecedor() != null && p.getFornecedor().getId() != null) {
                stmt.setLong(11, p.getFornecedor().getId());
            } else {
                stmt.setNull(11, Types.BIGINT);
            }
            stmt.setBoolean(12, p.getAtivo() != null ? p.getAtivo() : true);
            stmt.setTimestamp(13, Timestamp.valueOf(p.getCriadoEm() != null ? p.getCriadoEm() : LocalDateTime.now()));
            stmt.setTimestamp(14, Timestamp.valueOf(p.getAtualizadoEm() != null ? p.getAtualizadoEm() : LocalDateTime.now()));
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    p.setId(keys.getLong(1));
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public Produto update(Produto p) {
        String sql = "UPDATE produto SET nome = ?, categoria = ?, preco_custo = ?, preco_venda = ?, fornecedor_id = ?, atualizado_em = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getCategoria());
            stmt.setBigDecimal(3, p.getPrecoCusto());
            stmt.setBigDecimal(4, p.getPrecoVenda());
            if (p.getFornecedor() != null && p.getFornecedor().getId() != null) {
                stmt.setLong(5, p.getFornecedor().getId());
            } else {
                stmt.setNull(5, Types.BIGINT);
            }
            stmt.setTimestamp(6, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(7, p.getId());
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return p;
    }

    public void updateEstoque(Long id, Integer novoEstoque, Connection conn) throws SQLException {
        String sql = "UPDATE produto SET estoque_atual = ?, atualizado_em = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, novoEstoque);
            stmt.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            stmt.setLong(3, id);
            stmt.executeUpdate();
        }
    }

    public void deleteById(Long id) {
        String sql = "DELETE FROM produto WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setLong(1, id);
            stmt.executeUpdate();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private Produto mapRow(ResultSet rs) throws SQLException {
        Produto p = new Produto();
        p.setId(rs.getLong("id"));
        p.setNome(rs.getString("nome"));
        p.setDescricao(rs.getString("descricao"));
        p.setCodigoBarras(rs.getString("codigo_barras"));
        p.setCategoria(rs.getString("categoria"));
        p.setUnidadeMedida(rs.getString("unidade_medida"));
        p.setPrecoCusto(rs.getBigDecimal("preco_custo"));
        p.setPrecoVenda(rs.getBigDecimal("preco_venda"));
        p.setEstoqueAtual(rs.getInt("estoque_atual"));
        p.setEstoqueMinimo(rs.getInt("estoque_minimo"));
        p.setValidadeDias(rs.getInt("validade_dias"));
        p.setAtivo(rs.getBoolean("ativo"));
        p.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
        p.setAtualizadoEm(rs.getTimestamp("atualizado_em").toLocalDateTime());

        long fid = rs.getLong("f_id");
        if (!rs.wasNull() && fid > 0) {
            Fornecedor f = new Fornecedor();
            f.setId(fid);
            f.setNome(rs.getString("f_nome"));
            f.setCnpj(rs.getString("f_cnpj"));
            f.setTelefone(rs.getString("f_telefone"));
            f.setEmail(rs.getString("f_email"));
            f.setEndereco(rs.getString("f_endereco"));
            f.setAtivo(rs.getBoolean("f_ativo"));
            Timestamp fts = rs.getTimestamp("f_criado_em");
            if (fts != null) {
                f.setCriadoEm(fts.toLocalDateTime());
            }
            p.setFornecedor(f);
        }
        return p;
    }
}
