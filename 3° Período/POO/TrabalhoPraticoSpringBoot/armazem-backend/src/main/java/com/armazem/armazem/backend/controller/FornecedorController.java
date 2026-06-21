package com.armazem.armazem.backend.controller;

import com.armazem.armazem.backend.model.Fornecedor;
import com.armazem.armazem.backend.service.FornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/fornecedores")
@CrossOrigin(origins = "*")
public class FornecedorController {

    @Autowired
    private FornecedorService service;

    @GetMapping
    public List<Fornecedor> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public Fornecedor criar(@RequestBody Fornecedor fornecedor) {
        return service.salvar(fornecedor);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Fornecedor> atualizar(@PathVariable Long id, @RequestBody Fornecedor fornecedor) {
        try {
            return ResponseEntity.ok(service.atualizar(id, fornecedor));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Fornecedor> buscar(@PathVariable Long id) {
        Fornecedor fornecedor = service.buscarPorId(id);
        if (fornecedor != null) {
            return ResponseEntity.ok(fornecedor);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
