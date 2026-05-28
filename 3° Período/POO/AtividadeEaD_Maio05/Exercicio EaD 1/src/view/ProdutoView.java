package view;

import model.Produto;
import java.util.List;

public class ProdutoView {

    public void exibirMensagemCadastro(Produto produto) {
        System.out.printf("Cadastrando produto: %s - R$%.2f - %d unidades\n", 
            produto.getNome(), produto.getPreco(), produto.getQntEstoque());
    }

    public void exibirListaProdutos(List<Produto> produtos) {
        System.out.println("Lista de produtos:");
        for (Produto p : produtos) {
            System.out.printf("%s - R$%.2f - %d unidades\n", 
                p.getNome(), p.getPreco(), p.getQntEstoque());
        }
    }

    public void exibirBusca(String nomeBuscado, Produto produto) {
        System.out.println("Buscando '" + nomeBuscado + "':");
        if (produto != null) {
            System.out.printf("%s - R$%.2f - %d unidades\n", 
                produto.getNome(), produto.getPreco(), produto.getQntEstoque());
        } else {
            System.out.println("Produto não encontrado.");
        }
    }
}