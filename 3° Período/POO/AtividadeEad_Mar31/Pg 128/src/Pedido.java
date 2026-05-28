import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private int numero;
    private LocalDate data;
    private List<ItemPedido> itens;

    public Pedido(int numero, LocalDate data) {
        this.numero = numero;
        this.data = data;
        this.itens = new ArrayList<>();
    }

    public int getNumero() {
        return numero;
    }

    public LocalDate getData() {
        return data;
    }

    public void adicionarItem(ItemPedido item) {
        itens.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemPedido item : itens) {
            total += item.calcularSubtotal();
        }
        return total;
    }

    public void listarItens() {
        if (itens.isEmpty()) {
            System.out.println("Pedido sem itens.");
            return;
        }

        System.out.println("Itens do pedido:");
        for (ItemPedido item : itens) {
            System.out.println(item);
        }
    }
}