package com.armazem.backend.repository;

import com.armazem.backend.config.DatabaseConnection;
import com.armazem.backend.model.Perfil;
import com.armazem.backend.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Optional;

public class UsuarioDAO {

    public Optional<Usuario> findByUsername(String username) {
        String sql = "SELECT * FROM usuario WHERE username = ?";
        try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, username);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    Usuario u = new Usuario();
                    u.setId(rs.getLong("id"));
                    u.setUsername(rs.getString("username"));
                    u.setSenha(rs.getString("senha"));
                    u.setPerfil(Perfil.valueOf(rs.getString("perfil")));
                    return Optional.of(u);
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return Optional.empty();
    }
}
