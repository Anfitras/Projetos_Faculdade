package com.armazem.backend.config;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class UsuarioPadraoSeeder {

    @Bean
    public CommandLineRunner seedUsuariosPadrao(JdbcTemplate jdbcTemplate) {
        return args -> {
            inserirOuAtualizar(jdbcTemplate, "admin", "admin123", "ADMIN");
            inserirOuAtualizar(jdbcTemplate, "caixa", "caixa123", "OPERADOR_CAIXA");
            inserirOuAtualizar(jdbcTemplate, "gerente", "gerente123", "GERENTE");
        };
    }

    private void inserirOuAtualizar(
            JdbcTemplate jdbcTemplate,
            String username,
            String senha,
            String perfil
    ) {
        jdbcTemplate.update(
                "INSERT INTO usuario (username, senha, perfil) VALUES (?, ?, ?) "
                        + "ON DUPLICATE KEY UPDATE senha = VALUES(senha), perfil = VALUES(perfil)",
                username,
                senha,
                perfil
        );
    }
}