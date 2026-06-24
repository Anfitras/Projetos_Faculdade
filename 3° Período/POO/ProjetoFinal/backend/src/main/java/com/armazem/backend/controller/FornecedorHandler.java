package com.armazem.backend.controller;

import com.armazem.backend.model.Fornecedor;
import com.armazem.backend.service.FornecedorService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class FornecedorHandler extends BaseHandler {

    private final FornecedorService fornecedorService = new FornecedorService();

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
                    List<Fornecedor> fornecedores = fornecedorService.listarTodos();
                    responderJson(exchange, 200, fornecedores);
                } else {
                    Fornecedor fornecedor = fornecedorService.buscarPorId(id);
                    if (fornecedor != null) {
                        responderJson(exchange, 200, fornecedor);
                    } else {
                        responderErro(exchange, 404, "Fornecedor nao encontrado");
                    }
                }
            } else if ("POST".equalsIgnoreCase(method)) {
                Fornecedor fornecedor = mapper.readValue(exchange.getRequestBody(), Fornecedor.class);
                Fornecedor salvo = fornecedorService.salvar(fornecedor);
                responderJson(exchange, 200, salvo);
            } else if ("PUT".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                Fornecedor fornecedor = mapper.readValue(exchange.getRequestBody(), Fornecedor.class);
                Fornecedor atualizado = fornecedorService.atualizar(id, fornecedor);
                responderJson(exchange, 200, atualizado);
            } else if ("DELETE".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                fornecedorService.deletar(id);
                exchange.sendResponseHeaders(204, -1);
            } else {
                responderErro(exchange, 405, "Metodo nao permitido");
            }
        } catch (RuntimeException e) {
            responderErro(exchange, 404, "Recurso nao encontrado");
        } catch (Exception e) {
            responderErro(exchange, 500, "Erro interno do servidor");
        }
    }
}
