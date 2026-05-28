package service;

import model.Produto;
import repository.ProdutoRepository;
import java.util.List;

public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoService(ProdutoRepository repository) {
        this.repository = repository;
    }

    public void cadastrarProduto(Produto produto) {
        repository.salvar(produto);
    }

    public List<Produto> listarProdutos() {
        return repository.listarTodos();
    }

    public Produto buscarProdutoPorNome(String nome) {
        return repository.buscarPorNome(nome);
    }
}