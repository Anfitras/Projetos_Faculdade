package controller;

import java.util.List;
import model.Usuario;
import service.UsuarioService;
import view.UsuarioView;

public class UsuarioController {
    private UsuarioService service;
    private UsuarioView view;

    public UsuarioController() {
        this.service = new UsuarioService();
        this.view = new UsuarioView();
    }

    public void listar() {
        List<Usuario> usuarios = service.listarUsuarios();
        view.exibirUsuarios(usuarios);
    }

    public void buscar(String email) {
        Usuario u = service.findByEmail(email);
        if (u == null) {
            view.exibirMensagem("Usuário não encontrado");
        } else {
            if (u.getTelefone() == null || u.getTelefone().isEmpty()) {
                view.exibirMensagem(u.getNome() + " - " + u.getEmail() + " - " + u.getTipo());
            } else {
                view.exibirMensagem(u.getNome() + " - " + u.getEmail() + " - " + u.getTelefone() + " - " + u.getTipo());
            }
        }
    }

    public void cadastrar(String nome, String email, String telefone) {
        String tipoAtual = view.solicitarTipoUsuario();
        String resultado = service.cadastrar(nome, email, telefone, tipoAtual);
        view.exibirMensagem(resultado);
    }

    public void cadastrar(String nome, String email) {
        cadastrar(nome, email, null);
    }
}