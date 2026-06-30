package com.armazem.backend.service;

import com.armazem.backend.model.Produto;
import com.armazem.backend.repository.ProdutoDAO;
import java.time.LocalDateTime;
import java.util.List;

public class ProdutoService {

    private final ProdutoDAO produtoDAO = new ProdutoDAO();

    public List<Produto> listarTodos() {
        return produtoDAO.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoDAO.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto salvar(Produto produto) {
        produto.setCriadoEm(LocalDateTime.now());
        produto.setAtualizadoEm(LocalDateTime.now());
        if (produto.getAtivo() == null) {
            produto.setAtivo(true);
        }
        if (produto.getEstoqueAtual() == null) {
            produto.setEstoqueAtual(0);
        }
        return produtoDAO.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
        produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
        produto.setFornecedor(produtoAtualizado.getFornecedor());
        produto.setAtualizadoEm(LocalDateTime.now());
        return produtoDAO.update(produto);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        produtoDAO.deleteById(id);
    }
}
