public class ItemPedido {
    private Pedido pedido;
    private String produto;
    private int quantidade;
    private double precoUnitario;

    public ItemPedido(Pedido pedido, String produto, int quantidade, double precoUnitario) {
        if (pedido == null) {
            throw new IllegalArgumentException("ItemPedido precisa estar associado a um Pedido.");
        }
        this.pedido = pedido;
        this.produto = produto;
        this.quantidade = quantidade;
        this.precoUnitario = precoUnitario;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public String getProduto() {
        return produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public double getPrecoUnitario() {
        return precoUnitario;
    }

    public double getSubtotal() {
        return quantidade * precoUnitario;
    }
}
