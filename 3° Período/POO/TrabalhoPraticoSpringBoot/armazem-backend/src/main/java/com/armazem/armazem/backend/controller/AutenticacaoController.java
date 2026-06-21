package com.armazem.armazem.backend.controller;

import com.armazem.armazem.backend.dto.LoginRequestDTO;
import com.armazem.armazem.backend.model.Usuario;
import com.armazem.armazem.backend.service.UsuarioService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AutenticacaoController {

    private final UsuarioService usuarioService;

    public AutenticacaoController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDTO loginRequest) {
        try {
            Usuario usuario = usuarioService.autenticar(loginRequest.getUsername(), loginRequest.getSenha());
            return ResponseEntity.ok(usuario);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).body(e.getMessage());
        }
    }
}
