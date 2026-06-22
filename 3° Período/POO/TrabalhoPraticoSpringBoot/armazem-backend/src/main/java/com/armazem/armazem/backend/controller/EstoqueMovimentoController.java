package com.armazem.armazem.backend.controller;

import com.armazem.armazem.backend.model.EstoqueMovimento;
import com.armazem.armazem.backend.service.EstoqueMovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimentos")
@CrossOrigin(origins = "*")
public class EstoqueMovimentoController {

    @Autowired
    private EstoqueMovimentoService service;

    @GetMapping
    public List<EstoqueMovimento> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public ResponseEntity<EstoqueMovimento> registrar(@RequestBody EstoqueMovimento movimento) {
        try {
            EstoqueMovimento salvo = service.registrarMovimento(movimento);
            return ResponseEntity.ok(salvo);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
