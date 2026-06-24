package com.armazem.backend;

import com.armazem.backend.controller.*;
import com.sun.net.httpserver.HttpServer;
import java.net.InetSocketAddress;
import java.util.concurrent.Executors;

public class ArmazemApplication {

    public static void main(String[] args) {
        try {
            HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);

            server.createContext("/api/auth", new AutenticacaoHandler());
            server.createContext("/api/clientes", new ClienteHandler());
            server.createContext("/api/fornecedores", new FornecedorHandler());
            server.createContext("/api/produtos", new ProdutoHandler());
            server.createContext("/api/movimentos", new EstoqueMovimentoHandler());
            server.createContext("/api/vendas", new VendaHandler());
            server.createContext("/api/dashboard", new DashboardHandler());

            server.setExecutor(Executors.newFixedThreadPool(10));
            server.start();

            System.out.println("Servidor Armazém (Nativo) iniciado com sucesso na porta 8080...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
