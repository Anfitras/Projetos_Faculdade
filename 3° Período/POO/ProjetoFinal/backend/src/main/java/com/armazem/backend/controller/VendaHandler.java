package com.armazem.backend.controller;

import com.armazem.backend.model.Venda;
import com.armazem.backend.service.VendaService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class VendaHandler extends BaseHandler {

    private final VendaService vendaService = new VendaService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (processarPreflight(exchange)) {
            return;
        }
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();

        try {
            if ("GET".equalsIgnoreCase(method) && "/api/vendas".equals(path)) {
                List<Venda> vendas = vendaService.listarTodas();
                responderJson(exchange, 200, vendas);
            } else if ("POST".equalsIgnoreCase(method) && "/api/vendas".equals(path)) {
                Venda venda = mapper.readValue(exchange.getRequestBody(), Venda.class);
                Venda salva = vendaService.registrarVenda(venda);
                responderJson(exchange, 200, salva);
            } else if ("PUT".equalsIgnoreCase(method) && path.endsWith("/cancelar")) {
                String[] partes = path.split("/");
                Long id = Long.parseLong(partes[3]);
                Venda cancelada = vendaService.cancelarVenda(id);
                responderJson(exchange, 200, cancelada);
            } else {
                responderErro(exchange, 405, "Rota nao permitida");
            }
        } catch (RuntimeException e) {
            responderErro(exchange, 400, e.getMessage());
        } catch (Exception e) {
            responderErro(exchange, 500, "Erro interno do servidor");
        }
    }
}
