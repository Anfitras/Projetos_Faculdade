package com.armazem.backend.controller;

import com.armazem.backend.model.Produto;
import com.armazem.backend.service.ProdutoService;
import com.sun.net.httpserver.HttpExchange;
import java.io.IOException;
import java.util.List;

public class ProdutoHandler extends BaseHandler {

    private final ProdutoService produtoService = new ProdutoService();

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
                    List<Produto> produtos = produtoService.listarTodos();
                    responderJson(exchange, 200, produtos);
                } else {
                    Produto produto = produtoService.buscarPorId(id);
                    if (produto != null) {
                        responderJson(exchange, 200, produto);
                    } else {
                        responderErro(exchange, 404, "Produto nao encontrado");
                    }
                }
            } else if ("POST".equalsIgnoreCase(method)) {
                Produto produto = mapper.readValue(exchange.getRequestBody(), Produto.class);
                Produto salvo = produtoService.salvar(produto);
                responderJson(exchange, 200, salvo);
            } else if ("PUT".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                Produto produto = mapper.readValue(exchange.getRequestBody(), Produto.class);
                Produto atualizado = produtoService.atualizar(id, produto);
                responderJson(exchange, 200, atualizado);
            } else if ("DELETE".equalsIgnoreCase(method)) {
                if (id == null) {
                    throw new IllegalArgumentException("ID ausente na URL");
                }
                produtoService.deletar(id);
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
