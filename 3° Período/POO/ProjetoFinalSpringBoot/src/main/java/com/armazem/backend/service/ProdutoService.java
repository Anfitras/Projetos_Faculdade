package com.armazem.backend.service;

import com.armazem.backend.model.Produto;
import com.armazem.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public List<Produto> listarTodos() {
        return produtoRepository.findAll();
    }

    public Produto buscarPorId(Long id) {
        return produtoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
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
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        Produto produto = buscarPorId(id);
        produto.setNome(produtoAtualizado.getNome());
        produto.setCategoria(produtoAtualizado.getCategoria());
        produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
        produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
        produto.setFornecedor(produtoAtualizado.getFornecedor());
        produto.setAtualizadoEm(LocalDateTime.now());
        return produtoRepository.save(produto);
    }

    public void deletar(Long id) {
        buscarPorId(id);
        produtoRepository.deleteById(id);
    }
}
