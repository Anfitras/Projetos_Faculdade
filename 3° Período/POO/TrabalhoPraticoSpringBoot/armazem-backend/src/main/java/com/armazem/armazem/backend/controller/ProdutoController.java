package com.armazem.armazem.backend.controller;

import com.armazem.armazem.backend.model.Produto;
import com.armazem.armazem.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/produtos")
@CrossOrigin(origins = "*")
public class ProdutoController {

    @Autowired
    private ProdutoService service;

    @GetMapping
    public List<Produto> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Produto criar(@RequestBody Produto produto) {
        return service.salvar(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Produto> atualizar(@PathVariable Long id, @RequestBody Produto produto) {
        try {
            return ResponseEntity.ok(service.atualizar(id, produto));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Produto> buscar(@PathVariable Long id) {
        Produto produto = service.buscarPorId(id);
        if (produto != null) {
            return ResponseEntity.ok(produto);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
