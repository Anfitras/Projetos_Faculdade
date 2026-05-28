import java.util.ArrayList;
import java.util.List;

public class Turma {
    private String nome;
    private String horario;
    private List<Aluno> alunos;

    public Turma(String nome, String horario) {
        this.nome = nome;
        this.horario = horario;
        this.alunos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public String getHorario() {
        return horario;
    }

    public void adicionarAluno(Aluno aluno) {
        alunos.add(aluno);
    }

    public void listarAlunos() {
        if (alunos.isEmpty()) {
            System.out.println("Turma sem alunos.");
            return;
        }

        for (Aluno aluno : alunos) {
            System.out.println(aluno);
        }
    }
}