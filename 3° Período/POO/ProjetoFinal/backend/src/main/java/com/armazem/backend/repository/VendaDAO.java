package com.armazem.backend.repository;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.dto.ProdutoTopVendaDTO;
import com.armazem.backend.model.*;
import java.math.BigDecimal;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.*;

public class VendaDAO {

    public List<Venda> findAll() {
        return carregarVendasRAM("SELECT * FROM venda ORDER BY id DESC", null);
    }

    public List<Venda> findTop5() {
        return carregarVendasRAM("SELECT * FROM venda ORDER BY id DESC LIMIT 5", null);
    }

    public Optional<Venda> findById(Long id, Connection conn) throws SQLException {
        List<Venda> lista = carregarVendasRAM("SELECT * FROM venda WHERE id = " + id, conn);
        return lista.isEmpty() ? Optional.empty() : Optional.of(lista.get(0));
    }

    private List<Venda> carregarVendasRAM(String sqlVendas, Connection connTransacao) {
        List<Venda> vendas = new ArrayList<>();
        Map<Long, Cliente> mapaClientes = new HashMap<>();
        Map<Long, Produto> mapaProdutos = new HashMap<>();
        Map<Long, List<VendaItem>> mapaItens = new HashMap<>();

        Connection conn = connTransacao;
        boolean fecharConn = false;

        try {
            if (conn == null) {
                conn = DatabaseConnection.getConnection();
                fecharConn = true;
            }

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM cliente")) {
                while (rs.next()) {
                    mapaClientes.put(rs.getLong("id"), new Cliente(rs.getLong("id"), rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"), rs.getString("email")));
                }
            }

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT id, nome, preco_venda FROM produto")) {
                while (rs.next()) {
                    Produto p = new Produto();
                    p.setId(rs.getLong("id"));
                    p.setNome(rs.getString("nome"));
                    p.setPrecoVenda(rs.getBigDecimal("preco_venda"));
                    mapaProdutos.put(p.getId(), p);
                }
            }

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery("SELECT * FROM venda_item")) {
                while (rs.next()) {
                    Long vendaId = rs.getLong("venda_id");
                    VendaItem vi = new VendaItem();
                    vi.setId(rs.getLong("id"));
                    vi.setQuantidade(rs.getInt("quantidade"));
                    vi.setPrecoUnitario(rs.getBigDecimal("preco_unitario"));
                    vi.setSubtotal(rs.getBigDecimal("subtotal"));
                    Produto p = mapaProdutos.get(rs.getLong("produto_id"));
                    if (p == null) {
                        p = new Produto();
                        p.setNome("[Excluído]");
                    }
                    vi.setProduto(p);

                    mapaItens.computeIfAbsent(vendaId, k -> new ArrayList<>()).add(vi);
                }
            }

            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sqlVendas)) {
                while (rs.next()) {
                    Venda v = new Venda();
                    v.setId(rs.getLong("id"));
                    v.setTotal(rs.getBigDecimal("total"));
                    v.setDesconto(rs.getBigDecimal("desconto"));
                    v.setTotalFinal(rs.getBigDecimal("total_final"));
                    v.setFormaPagamento(FormaPagamento.valueOf(rs.getString("forma_pagamento")));
                    v.setObservacao(rs.getString("observacao"));
                    v.setStatus(rs.getString("status"));
                    v.setCriadoEm(rs.getTimestamp("criado_em").toLocalDateTime());
                    v.setCliente(mapaClientes.get(rs.getLong("cliente_id")));

                    List<VendaItem> itensVenda = mapaItens.get(v.getId());
                    v.setItens(itensVenda != null ? itensVenda : new ArrayList<>());
                    vendas.add(v);
                }
            }

            if (fecharConn) {
                conn.close();
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return vendas;
    }

    public void save(Venda v, Connection conn) throws SQLException {
        String sql = "INSERT INTO venda (total, desconto, total_final, forma_pagamento, observacao, status, criado_em, cliente_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setBigDecimal(1, v.getTotal());
            stmt.setBigDecimal(2, v.getDesconto());
            stmt.setBigDecimal(3, v.getTotalFinal());
            stmt.setString(4, v.getFormaPagamento().name());
            stmt.setString(5, v.getObservacao());
            stmt.setString(6, v.getStatus());
            stmt.setTimestamp(7, Timestamp.valueOf(v.getCriadoEm() != null ? v.getCriadoEm() : LocalDateTime.now()));
            if (v.getCliente() != null && v.getCliente().getId() != null) {
                stmt.setLong(8, v.getCliente().getId());
            } else {
                stmt.setNull(8, Types.BIGINT);
            }
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    v.setId(keys.getLong(1));
                }
            }
        }
    }

    public void saveItem(VendaItem item, Long vendaId, Connection conn) throws SQLException {
        String sql = "INSERT INTO venda_item (venda_id, produto_id, quantidade, preco_unitario, subtotal) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setLong(1, vendaId);
            stmt.setLong(2, item.getProduto().getId());
            stmt.setInt(3, item.getQuantidade());
            stmt.setBigDecimal(4, item.getPrecoUnitario());
            stmt.setBigDecimal(5, item.getSubtotal());
            stmt.executeUpdate();
            try (ResultSet keys = stmt.getGeneratedKeys()) {
                if (keys.next()) {
                    item.setId(keys.getLong(1));
                }
            }
        }
    }

    public void updateStatus(Long id, String status, Connection conn) throws SQLException {
        String sql = "UPDATE venda SET status = ? WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, status);
            stmt.setLong(2, id);
            stmt.executeUpdate();
        }
    }

    public BigDecimal calcularFaturamentoMensal() {
        String sql = "SELECT SUM(total_final) FROM venda WHERE status = 'CONCLUIDA' AND MONTH(criado_em) = MONTH(CURRENT_DATE()) AND YEAR(criado_em) = YEAR(CURRENT_DATE())";
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

    public List<ProdutoTopVendaDTO> findTopProdutosVendidos() {
        List<ProdutoTopVendaDTO> lista = new ArrayList<>();
        String sql = "SELECT p.nome, SUM(vi.quantidade) FROM venda_item vi JOIN produto p ON vi.produto_id = p.id JOIN venda v ON vi.venda_id = v.id WHERE v.status = 'CONCLUIDA' GROUP BY p.id, p.nome ORDER BY SUM(vi.quantidade) DESC";
        try (Connection conn = DatabaseConnection.getConnection(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                lista.add(new ProdutoTopVendaDTO(rs.getString(1), rs.getLong(2)));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return lista;
    }
}
