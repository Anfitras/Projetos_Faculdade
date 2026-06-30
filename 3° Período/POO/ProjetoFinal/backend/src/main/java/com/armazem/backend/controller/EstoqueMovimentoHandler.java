package com.armazem.backend.controller;

import com.armazem.backend.model.EstoqueMovimento;
import com.armazem.backend.service.EstoqueMovimentoService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class EstoqueMovimentoHandler extends BaseHandler {

    private final EstoqueMovimentoService movimentoService = new EstoqueMovimentoService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (processarPreflight(exchange)) {
            return;
        }
        String method = exchange.getRequestMethod();

        try {
            if ("GET".equalsIgnoreCase(method)) {
                List<EstoqueMovimento> lista = movimentoService.listarTodos();
                responderJson(exchange, 200, lista);
            } else if ("POST".equalsIgnoreCase(method)) {
                EstoqueMovimento movimento = mapper.readValue(exchange.getRequestBody(), EstoqueMovimento.class);
                EstoqueMovimento salvo = movimentoService.registrarMovimento(movimento);
                responderJson(exchange, 200, salvo);
            } else {
                responderErro(exchange, 405, "Metodo nao permitido");
            }
        } catch (RuntimeException e) {
            responderErro(exchange, 400, e.getMessage());
        } catch (Exception e) {
            responderErro(exchange, 500, "Erro interno do servidor");
        }
    }
}
