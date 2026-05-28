import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Pedido {
    private int numero;
    private String descricao;
    private Cliente cliente;
    private List<ItemPedido> itens;

    public Pedido(int numero, String descricao, Cliente cliente) {
        this.numero = numero;
        this.descricao = descricao;
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public ItemPedido adicionarItem(String produto, int quantidade, double precoUnitario) {
        ItemPedido item = new ItemPedido(this, produto, quantidade, precoUnitario);
        itens.add(item);
        return item;
    }

    public List<ItemPedido> getItens() {
        return Collections.unmodifiableList(itens);
    }

    public double getValorTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }
}
