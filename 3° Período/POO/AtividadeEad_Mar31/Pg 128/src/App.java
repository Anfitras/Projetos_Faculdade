import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Agenda agenda1 = new Agenda();
        Agenda agenda2 = new Agenda();

        Contato c1 = new Contato("Ana", "(11) 99999-1111");
        Contato c2 = new Contato("Bruno", "(11) 98888-2222");
        Contato c3 = new Contato("Marcos", "(35) 99800-0000");

        agenda1.adicionarContato(c1);
        agenda1.adicionarContato(c2);
        agenda2.adicionarContato(c3);

        System.out.println("--- Agenda 1 ---");
        agenda1.listarContatos();

        System.out.println("--- Agenda 2 ---");
        agenda2.listarContatos();

        System.out.println("\n--- Pedido de Compra ---");
        Pedido pedido = new Pedido(1001, LocalDate.now());

        ItemPedido item1 = new ItemPedido("Teclado", 1, 150.00);
        ItemPedido item2 = new ItemPedido("Mouse", 2, 80.00);
        ItemPedido item3 = new ItemPedido("Monitor", 1, 899.90);

        pedido.adicionarItem(item1);
        pedido.adicionarItem(item2);
        pedido.adicionarItem(item3);

        System.out.println("Numero do pedido: " + pedido.getNumero());
        System.out.println("Data do pedido: " + pedido.getData());
        pedido.listarItens();
        System.out.println("Total do pedido: R$ " + String.format("%.2f", pedido.calcularTotal()));

        System.out.println("\n--- Escola de Musica ---");
        Escola escola = new Escola("Escola Som e Arte");

        Turma turmaIniciantes = new Turma("Iniciantes", "08:00");
        Turma turmaIntermediarios = new Turma("Intermediarios", "10:00");

        Aluno a1 = new Aluno("Julia", 14, new Violao("Yamaha"));
        Aluno a2 = new Aluno("Carlos", 16, new Bateria("Pearl"));
        Aluno a3 = new Aluno("Beatriz", 15, new Teclado("Casio"));

        turmaIniciantes.adicionarAluno(a1);
        turmaIniciantes.adicionarAluno(a2);
        turmaIntermediarios.adicionarAluno(a3);

        escola.adicionarTurma(turmaIniciantes);
        escola.adicionarTurma(turmaIntermediarios);

        System.out.println("Escola: " + escola.getNome());
        escola.listarTurmas();
    }
}
