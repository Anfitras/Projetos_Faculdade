package com.armazem.backend.controller;

import com.armazem.backend.dto.DashboardDTO;
import com.armazem.backend.service.DashboardService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;

public class DashboardHandler extends BaseHandler {

    private final DashboardService dashboardService = new DashboardService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (processarPreflight(exchange)) {
            return;
        }
        String method = exchange.getRequestMethod();

        if ("GET".equalsIgnoreCase(method)) {
            try {
                DashboardDTO dto = dashboardService.obterDadosDashboard();
                responderJson(exchange, 200, dto);
            } catch (Exception e) {
                responderErro(exchange, 500, e.getMessage());
            }
        } else {
            responderErro(exchange, 405, "Metodo nao permitido");
        }
    }
}
