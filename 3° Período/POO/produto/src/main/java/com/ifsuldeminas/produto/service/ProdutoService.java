package com.ifsuldeminas.produto.service;

import com.ifsuldeminas.produto.model.Produto;
import com.ifsuldeminas.produto.repository.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repository;

    public List<Produto> listar() {
        return repository.findAll();
    }

    public Produto salvar(Produto p) {
        return repository.save(p);
    }
}
