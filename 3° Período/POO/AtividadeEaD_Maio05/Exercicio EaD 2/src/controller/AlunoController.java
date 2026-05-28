package controller;

import model.Aluno;
import service.AlunoService;
import view.AlunoView;

public class AlunoController {
    private AlunoService service;
    private AlunoView view;

    public AlunoController(AlunoService service, AlunoView view) {
        this.service = service;
        this.view = view;
    }

    public void cadastrar(String nome, String matricula, double notaFinal) {
        String resultado = service.cadastrar(nome, matricula, notaFinal);
        view.exibirMensagemCadastro(nome, matricula, notaFinal, resultado);
    }

    public void listarTodos() {
        view.exibirListaAlunos(service.listar());
    }

    public void exibirMedia() {
        view.exibirMedia(service.calcularMedia());
    }
}
