package view;

import model.Aluno;
import java.util.List;

public class AlunoView {

    public void exibirMensagemCadastro(String nome, String matricula, double nota, String resultado) {
        System.out.printf("Cadastrando: %s, %s, %.1f -> %s\n", nome, matricula, nota, resultado);
    }

    public void exibirListaAlunos(List<Aluno> alunos) {
        System.out.println("Lista de alunos:");
        for (Aluno a : alunos) {
            System.out.printf("%s (%s) - %.1f\n", a.getNome(), a.getMatricula(), a.getNotaFinal());
        }
    }

    public void exibirMedia(double media) {
        System.out.printf("Média da turma: %.2f\n", media);
    }
}