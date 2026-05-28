package controller;

import model.Produto;
import service.ProdutoService;
import view.ProdutoView;

public class ProdutoController {
    private ProdutoService service;
    private ProdutoView view;

    public ProdutoController(ProdutoService service, ProdutoView view) {
        this.service = service;
        this.view = view;
    }

    public void cadastrar(String nome, double preco, int quantidade) {
        Produto produto = new Produto(nome, preco, quantidade);
        service.cadastrarProduto(produto);
        view.exibirMensagemCadastro(produto);
    }

    public void listarTodos() {
        view.exibirListaProdutos(service.listarProdutos());
    }

    public void buscarPorNome(String nome) {
        Produto produto = service.buscarProdutoPorNome(nome);
        view.exibirBusca(nome, produto);
    }
}