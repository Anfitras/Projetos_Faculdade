package com.armazem.backend.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import java.io.IOException;
import java.io.OutputStream;

public abstract class BaseHandler implements HttpHandler {

    protected final ObjectMapper mapper;

    public BaseHandler() {
        this.mapper = new ObjectMapper();
        this.mapper.registerModule(new JavaTimeModule());
        this.mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    protected void tratarCors(HttpExchange exchange) {
        exchange.getResponseHeaders().set("Access-Control-Allow-Origin", "*");
        exchange.getResponseHeaders().set("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS");
        exchange.getResponseHeaders().set("Access-Control-Allow-Headers", "Content-Type");
    }

    protected boolean processarPreflight(HttpExchange exchange) throws IOException {
        tratarCors(exchange);
        if ("OPTIONS".equalsIgnoreCase(exchange.getRequestMethod())) {
            exchange.sendResponseHeaders(204, -1);
            return true;
        }
        return false;
    }

    protected void responderJson(HttpExchange exchange, int status, Object obj) throws IOException {
        tratarCors(exchange);
        byte[] bytes = mapper.writeValueAsBytes(obj);
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    protected void responderErro(HttpExchange exchange, int status, String msg) throws IOException {
        tratarCors(exchange);
        byte[] bytes = msg.getBytes();
        exchange.sendResponseHeaders(status, bytes.length);
        try (OutputStream os = exchange.getResponseBody()) {
            os.write(bytes);
        }
    }

    protected Long extrairId(String path) {
        try {
            String sub = path.substring(path.lastIndexOf('/') + 1);
            return Long.parseLong(sub);
        } catch (Exception e) {
            return null;
        }
    }
}
