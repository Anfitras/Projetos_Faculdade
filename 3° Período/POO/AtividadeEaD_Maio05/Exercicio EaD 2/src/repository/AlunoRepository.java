package repository;

import model.Aluno;
import java.util.ArrayList;
import java.util.List;

public class AlunoRepository {
    private List<Aluno> alunos = new ArrayList<>();

    public void salvar(Aluno a) {
        alunos.add(a);
    }

    public List<Aluno> listarTodos() {
        return alunos;
    }

    public boolean existePorMatricula(String matricula) {
        for (Aluno a : alunos) {
            if (a.getMatricula().equalsIgnoreCase(matricula)) {
                return true;
            }
        }
        return false;
    }
}
