package service;

import java.util.List;
import model.Usuario;
import repository.UsuarioRepository;

public class UsuarioService {
    private UsuarioRepository repository;

    public UsuarioService() {
        this.repository = new UsuarioRepository();
    }

    public String cadastrar(String nome, String email, String telefone, String tipoDoUsuarioQueEstaCadastrando) {
        if (!"ADMIN".equalsIgnoreCase(tipoDoUsuarioQueEstaCadastrando)) {
            return "Apenas administradores podem cadastrar";
        }

        if (!emailValido(email)) {
            return "Erro: e-mail inválido";
        }

        if (repository.existePorEmail(email)) {
            return "Erro: e-mail já cadastrado";
        }

        Usuario novo = new Usuario(nome, email, telefone);
        novo.setTipo(tipoDoUsuarioQueEstaCadastrando);
        repository.salvar(novo);
        return "Usuário cadastrado com sucesso!";
    }

    public List<Usuario> listarUsuarios() {
        return repository.listar();
    }

    private boolean emailValido(String email) {
        if (email == null || email.isBlank()) {
            return false;
        }

        int posArroba = email.indexOf('@');

        if (posArroba <= 0 || posArroba == email.length() - 1) {
            return false;
        }

        return email.indexOf('.', posArroba) > posArroba + 1;
    }

    public Usuario findByEmail(String email) {
        return repository.findByEmail(email);
    }
}
