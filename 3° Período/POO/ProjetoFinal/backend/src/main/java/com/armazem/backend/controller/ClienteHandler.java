package com.armazem.backend.controller;

import com.armazem.backend.model.Cliente;
import com.armazem.backend.service.ClienteService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class ClienteHandler extends BaseHandler {

    private final ClienteService clienteService = new ClienteService();

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        if (processarPreflight(exchange)) {
            return;
        }
        String method = exchange.getRequestMethod();
        String path = exchange.getRequestURI().getPath();
        Long id = extrairId(path);

        try {
            if ("GET".equalsIgnoreCase(method)) {
                if (id == null) {
                    List<Cliente> clientes = clienteService.listarTodos();
                    responderJson(exchange, 200, clientes);
                } else {
                    Cliente cliente = clienteService.buscarPorId(id);
                    responderJson(exchange, 200, cliente);
                }
            } else if ("POST".equalsIgnoreCase(method)) {
                Cliente cliente = mapper.readValue(exchange.getRequestBody(), Cliente.class);
                Cliente salvo = clienteService.salvar(cliente);
                responderJson(exchange, 200, salvo);
            } else if ("PUT".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                Cliente cliente = mapper.readValue(exchange.getRequestBody(), Cliente.class);
                Cliente atualizado = clienteService.atualizar(id, cliente);
                responderJson(exchange, 200, atualizado);
            } else if ("DELETE".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                clienteService.deletar(id);
                responderJson(exchange, 200, "Deletado com sucesso");
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
