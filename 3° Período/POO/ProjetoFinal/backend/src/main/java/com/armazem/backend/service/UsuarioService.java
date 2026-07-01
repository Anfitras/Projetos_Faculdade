package com.armazem.backend.service;

import com.armazem.backend.model.Usuario;
import com.armazem.backend.repository.UsuarioDAO;
import java.util.Optional;

public class UsuarioService {

    private final UsuarioDAO usuarioDAO = new UsuarioDAO();

    public Usuario autenticar(String username, String senha) {
        Optional<Usuario> usuarioOpt = usuarioDAO.findByUsername(username);
        if (usuarioOpt.isPresent() && usuarioOpt.get().getSenha().equals(senha)) {
            return usuarioOpt.get();
        }
        throw new RuntimeException("Usuario ou senha invalidos");
    }
}
