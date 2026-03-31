import java.util.ArrayList;
import java.util.List;

public class Agenda {
    private List<Contato> contatos;

    public Agenda() {
        this.contatos = new ArrayList<>();
    }

    public void adicionarContato(Contato contato) {
        contatos.add(contato);
    }

    public void listarContatos() {
        if (contatos.isEmpty()) {
            System.out.println("Agenda vazia.");
            return;
        }

        System.out.println("Contatos cadastrados:");
        for (Contato contato : contatos) {
            System.out.println(contato);
        }
    }
}