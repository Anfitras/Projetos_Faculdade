package com.armazem.backend.controller;

import com.armazem.backend.dto.LoginRequestDTO;
import com.armazem.backend.model.Usuario;
import com.armazem.backend.service.UsuarioService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class AutenticacaoHandler extends BaseHandler {

    private final UsuarioService usuarioService = new UsuarioService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (processarPreflight(exchange)) {
            return;
        }
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        if ("POST".equalsIgnoreCase(method) && path.endsWith("/login")) {
            try {
                LoginRequestDTO request = mapper.readValue(exchange.getRequestBody(), LoginRequestDTO.class);
                Usuario usuario = usuarioService.autenticar(request.getUsername(), request.getSenha());
                responderJson(exchange, 200, usuario);
            } catch (RuntimeException e) {
                responderErro(exchange, 401, e.getMessage());
            } catch (Exception e) {
                responderErro(exchange, 400, "Requisicao invalida");
            }
        } else {
            responderErro(exchange, 405, "Metodo nao permitido");
        }
    }
}
