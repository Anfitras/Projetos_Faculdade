import java.util.ArrayList;
import java.util.List;

public class Escola {
    private String nome;
    private List<Turma> turmas;

    public Escola(String nome) {
        this.nome = nome;
        this.turmas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void adicionarTurma(Turma turma) {
        turmas.add(turma);
    }

    public void listarTurmas() {
        if (turmas.isEmpty()) {
            System.out.println("Escola sem turmas.");
            return;
        }

        for (Turma turma : turmas) {
            System.out.println("Turma: " + turma.getNome() + " | Horario: " + turma.getHorario());
            turma.listarAlunos();
            System.out.println();
        }
    }
}