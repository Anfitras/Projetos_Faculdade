package com.armazem.backend.controller;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.service.EstoqueMovimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/movimentos")
public class EstoqueMovimentoController {

    @Autowired
    private EstoqueMovimentoService movimentoService;

    @GetMapping
    public List<EstoqueMovimento> listar() {
        return movimentoService.listarTodos();
    }

    @PostMapping
    public ResponseEntity<?> criar(@RequestBody EstoqueMovimento movimento) {
        try {
            return ResponseEntity.ok(movimentoService.registrarMovimento(movimento));
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
