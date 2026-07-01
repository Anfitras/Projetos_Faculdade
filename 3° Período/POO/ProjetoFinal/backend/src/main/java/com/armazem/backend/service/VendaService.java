package com.armazem.backend.service;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.*;
import com.armazem.backend.repository.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class VendaService {

    private final VendaDAO vendaDAO = new VendaDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();
    private final EstoqueMovimentoDAO movimentoDAO = new EstoqueMovimentoDAO();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    public List<Venda> listarTodas() {
        return vendaDAO.findAll();
    }

    public Venda registrarVenda(Venda venda) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                if (venda.getCliente() != null && venda.getCliente().getId() != null) {
                    Cliente cliente = clienteDAO.findById(venda.getCliente().getId())
                            .orElseThrow(() -> new RuntimeException("Cliente não encontrado"));
                    venda.setCliente(cliente);
                } else {
                    venda.setCliente(null);
                }

                BigDecimal totalVenda = BigDecimal.ZERO;

                for (VendaItem item : venda.getItens()) {
                    Produto produto = produtoDAO.findById(item.getProduto().getId())
                            .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                    if (produto.getEstoqueAtual() < item.getQuantidade()) {
                        throw new RuntimeException("Estoque insuficiente para o produto: " + produto.getNome());
                    }

                    item.setProduto(produto);
                    item.setPrecoUnitario(produto.getPrecoVenda());
                    BigDecimal subtotal = item.getPrecoUnitario().multiply(new BigDecimal(item.getQuantidade()));
                    item.setSubtotal(subtotal);

                    totalVenda = totalVenda.add(subtotal);
                }

                venda.setTotal(totalVenda);
                if (venda.getDesconto() == null) {
                    venda.setDesconto(BigDecimal.ZERO);
                }
                venda.setTotalFinal(totalVenda.subtract(venda.getDesconto()));
                venda.setStatus("CONCLUIDA");
                venda.setCriadoEm(LocalDateTime.now());

                vendaDAO.save(venda, conn);

                for (VendaItem item : venda.getItens()) {
                    Produto produto = item.getProduto();
                    produto.setEstoqueAtual(produto.getEstoqueAtual() - item.getQuantidade());
                    produtoDAO.updateEstoque(produto.getId(), produto.getEstoqueAtual(), conn);

                    vendaDAO.saveItem(item, venda.getId(), conn);

                    EstoqueMovimento mov = new EstoqueMovimento();
                    mov.setProduto(produto);
                    mov.setTipo(TipoMovimento.SAIDA);
                    mov.setQuantidade(item.getQuantidade());
                    mov.setMotivo("Venda");
                    mov.setCriadoEm(LocalDateTime.now());
                    movimentoDAO.save(mov, conn);
                }

                conn.commit();
                return venda;
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Venda cancelarVenda(Long id) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                Venda venda = vendaDAO.findById(id, conn)
                        .orElseThrow(() -> new RuntimeException("Venda não encontrada"));

                if ("CANCELADA".equals(venda.getStatus())) {
                    throw new RuntimeException("A venda já se encontra cancelada.");
                }

                for (VendaItem item : venda.getItens()) {
                    Produto produto = item.getProduto();
                    produto.setEstoqueAtual(produto.getEstoqueAtual() + item.getQuantidade());
                    produtoDAO.updateEstoque(produto.getId(), produto.getEstoqueAtual(), conn);

                    EstoqueMovimento mov = new EstoqueMovimento();
                    mov.setProduto(produto);
                    mov.setTipo(TipoMovimento.ENTRADA);
                    mov.setQuantidade(item.getQuantidade());
                    mov.setMotivo("Estorno de Venda");
                    mov.setObservacao("Cancelamento da Venda #" + venda.getId());
                    mov.setCriadoEm(LocalDateTime.now());
                    movimentoDAO.save(mov, conn);
                }

                vendaDAO.updateStatus(venda.getId(), "CANCELADA", conn);
                venda.setStatus("CANCELADA");

                conn.commit();
                return venda;
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
