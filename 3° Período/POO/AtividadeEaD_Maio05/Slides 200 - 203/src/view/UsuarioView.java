package view;

import java.util.List;
import java.util.Scanner;
import model.Usuario;

public class UsuarioView {
    private static Scanner sc = new Scanner(System.in);

    public void exibirMensagem(String msg) {
        System.out.println(msg);
    }

    public void exibirUsuarios(List<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getTelefone() == null || u.getTelefone().isEmpty()) {
                System.out.println(u.getNome() + " - " + u.getEmail() + " - " + u.getTipo());
            } else {
                System.out.println(u.getNome() + " - " + u.getEmail() + " - " + u.getTelefone() + " - " + u.getTipo());
            }
        }
    }

    public String solicitarTipoUsuario() {
        System.out.print("Qual seu tipo? (ADMIN/COMUM) ");
        String tipo = sc.nextLine().trim();
        return tipo;
    }
}
