import controller.ProdutoController;
import repository.ProdutoRepository;
import service.ProdutoService;
import view.ProdutoView;

public class App {
    public static void main(String[] args) {
        ProdutoRepository repository = new ProdutoRepository();
        ProdutoService service = new ProdutoService(repository);
        ProdutoView view = new ProdutoView();
        ProdutoController controller = new ProdutoController(service, view);

        controller.cadastrar("Notebook", 2500.00, 10);
        controller.cadastrar("Mouse", 80.00, 50);

        System.out.println();
        controller.listarTodos();

        System.out.println();
        controller.buscarPorNome("Mouse");

        System.out.println();
        controller.buscarPorNome("Teclado");
    }
}