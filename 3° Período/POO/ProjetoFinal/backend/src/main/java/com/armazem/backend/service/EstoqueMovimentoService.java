package com.armazem.backend.service;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.model.Produto;
import com.armazem.backend.model.TipoMovimento;
import com.armazem.backend.repository.EstoqueMovimentoDAO;
import com.armazem.backend.repository.ProdutoDAO;
import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.List;

public class EstoqueMovimentoService {

    private final EstoqueMovimentoDAO movimentoDAO = new EstoqueMovimentoDAO();
    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public List<EstoqueMovimento> listarTodos() {
        return movimentoDAO.findAll();
    }

    public EstoqueMovimento registrarMovimento(EstoqueMovimento movimento) {
        try (Connection conn = DatabaseConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                Produto produto = produtoDAO.findById(movimento.getProduto().getId())
                        .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

                if (movimento.getTipo() == TipoMovimento.ENTRADA) {
                    produto.setEstoqueAtual(produto.getEstoqueAtual() + movimento.getQuantidade());
                } else if (movimento.getTipo() == TipoMovimento.SAIDA) {
                    if (produto.getEstoqueAtual() < movimento.getQuantidade()) {
                        throw new RuntimeException("Estoque insuficiente");
                    }
                    produto.setEstoqueAtual(produto.getEstoqueAtual() - movimento.getQuantidade());
                }

                produto.setAtualizadoEm(LocalDateTime.now());
                produtoDAO.updateEstoque(produto.getId(), produto.getEstoqueAtual(), conn);

                movimento.setProduto(produto);
                movimento.setCriadoEm(LocalDateTime.now());
                movimentoDAO.save(movimento, conn);

                conn.commit();
                return movimento;
            } catch (Exception e) {
                conn.rollback();
                throw new RuntimeException(e.getMessage());
            }
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}
