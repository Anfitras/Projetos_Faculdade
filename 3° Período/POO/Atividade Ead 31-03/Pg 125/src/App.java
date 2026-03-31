public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("--- Pedido e Cliente ---");
        Cliente cliente = new Cliente("Maria Silva", "123.456.789-00");
        Pedido pedido = new Pedido(1, "Notebook", cliente);

        System.out.println("Pedido #" + pedido.getNumero());
        System.out.println("Descricao: " + pedido.getDescricao());
        System.out.println("Cliente: " + pedido.getCliente().getNome());

        System.out.println();
        System.out.println("--- Pedido e Itens ---");
        pedido.adicionarItem("Mouse", 2, 80.0);
        pedido.adicionarItem("Teclado", 1, 150.0);

        System.out.println("Itens do pedido:");
        for (ItemPedido item : pedido.getItens()) {
            System.out.println("- " + item.getProduto() + " | Qtd: " + item.getQuantidade() + " | Subtotal: R$ "
                    + item.getSubtotal());
        }
        System.out.println("Total do pedido: R$ " + pedido.getValorTotal());

        System.out.println();
        System.out.println("--- Time e Jogadores ---");

        Jogador jogador1 = new Jogador("Lucas", "Atacante");
        Jogador jogador2 = new Jogador("Bruno", "Zagueiro");
        Jogador jogador3 = new Jogador("Caio", "Goleiro");

        Time time = new Time("Leoes FC");
        time.adicionarJogador(jogador1);
        time.adicionarJogador(jogador2);
        time.adicionarJogador(jogador3);

        System.out.println("Time: " + time.getNome());
        System.out.println("Jogadores do time:");
        for (Jogador jogador : time.getJogadores()) {
            System.out.println("- " + jogador.getNome() + " (" + jogador.getPosicao() + ")");
        }
    }
}
