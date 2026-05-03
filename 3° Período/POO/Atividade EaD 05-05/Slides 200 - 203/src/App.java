import controller.UsuarioController;

public class App {
    public static void main(String[] args) throws Exception {
        UsuarioController controller = new UsuarioController();
        controller.cadastrar("João", "joao@email.com", "35998000000");
        controller.cadastrar("Maria", "maria@email.com");
        controller.cadastrar("João", "joao@gmail.com", "35998000575");
        System.out.println();
        controller.listar();

        controller.buscar("joao@gmail.com");
    }
}
