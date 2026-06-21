package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Produto;
import com.armazem.armazem.backend.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listarTodos() {
        return repository.findAll();
    }

    public Produto salvar(Produto produto) {
        return repository.save(produto);
    }

    public Produto atualizar(Long id, Produto produtoAtualizado) {
        return repository.findById(id).map(produto -> {
            produto.setNome(produtoAtualizado.getNome());
            produto.setCategoria(produtoAtualizado.getCategoria());
            produto.setPrecoCusto(produtoAtualizado.getPrecoCusto());
            produto.setPrecoVenda(produtoAtualizado.getPrecoVenda());
            produto.setFornecedor(produtoAtualizado.getFornecedor());
            produto.setAtualizadoEm(LocalDateTime.now());
            return repository.save(produto);
        }).orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }

    public Produto buscarPorId(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
