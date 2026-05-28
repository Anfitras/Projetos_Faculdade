package service;

import model.Aluno;
import repository.AlunoRepository;
import java.util.List;

public class AlunoService {
    private AlunoRepository repository;

    public AlunoService(AlunoRepository repository) {
        this.repository = repository;
    }

    public String cadastrar(String nome, String matricula, double nota) {
        if (nota < 0 || nota > 10) {
            return "Erro: nota inválida";
        }

        if (repository.existePorMatricula(matricula)) {
            return "Erro: matrícula já cadastrada";
        }

        Aluno novoAluno = new Aluno(nome, matricula, nota);
        repository.salvar(novoAluno);
        return "Sucesso";
    }

    public List<Aluno> listar() {
        return repository.listarTodos();
    }

    public double calcularMedia() {
        List<Aluno> alunos = repository.listarTodos();
        double soma = 0;
        int cont = 0;
        for (Aluno a : alunos) {
            soma += a.getNotaFinal();
            cont++;
        }
        if (cont == 0)
            return 0.0;

        double media = soma / cont;

        return media;
    }

}
