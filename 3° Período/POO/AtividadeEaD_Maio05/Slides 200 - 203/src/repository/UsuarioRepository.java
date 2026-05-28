package repository;

import java.util.ArrayList;
import java.util.List;

import model.Usuario;

public class UsuarioRepository {
    private static List<Usuario> banco = new ArrayList<>();

    public void salvar(Usuario usuario) {
        banco.add(usuario);
    }

    public boolean existePorEmail(String email) {
        for (Usuario u : banco) {
            if (u.getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    public List<Usuario> listar() {
        return new ArrayList<>(banco);
    }

    public Usuario findByEmail(String email) {
        for (Usuario u : banco) {
            if (email.equals(u.getEmail())) {
                return u;
            }
        }

        return null;
    }
}
