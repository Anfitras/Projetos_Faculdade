package com.armazem.armazem.backend.controller;

import com.armazem.armazem.backend.model.Venda;
import com.armazem.armazem.backend.service.VendaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/vendas")
@CrossOrigin(origins = "*")
public class VendaController {

    @Autowired
    private VendaService service;

    @GetMapping
    public List<Venda> listar() {
        return service.listarTodas();
    }

    @PostMapping
    public ResponseEntity<?> registrar(@RequestBody Venda venda) {
        try {
            Venda salva = service.registrarVenda(venda);
            return ResponseEntity.ok(salva);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PutMapping("/{id}/cancelar")
    public ResponseEntity<?> cancelar(@PathVariable Long id) {
        try {
            Venda cancelada = service.cancelarVenda(id);
            return ResponseEntity.ok(cancelada);
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
