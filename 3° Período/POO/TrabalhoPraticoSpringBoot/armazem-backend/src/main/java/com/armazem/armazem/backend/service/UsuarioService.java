package com.armazem.armazem.backend.service;

import com.armazem.armazem.backend.model.Usuario;
import com.armazem.armazem.backend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario autenticar(String username, String senha) {
        Optional<Usuario> usuarioOpt = usuarioRepository.findByUsername(username);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha)) {
            return usuarioOpt.get();
        }
        throw new RuntimeException("Usuario ou senha invalidos");
    }
}
