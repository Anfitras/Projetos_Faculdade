import controller.AlunoController;
import repository.AlunoRepository;
import service.AlunoService;
import view.AlunoView;

public class App {
    public static void main(String[] args) throws Exception {
        AlunoRepository repository = new AlunoRepository();
        AlunoService service = new AlunoService(repository);
        AlunoView view = new AlunoView();
        AlunoController controller = new AlunoController(service, view);

        controller.cadastrar("Ana", "101", 8.5);
        controller.cadastrar("Bruno", "102", 11.0);
        controller.cadastrar("Carlos", "101", 7.0);
        controller.cadastrar("Daniela", "103", 9.0);

        System.out.println();
        controller.listarTodos();

        System.out.println();
        controller.exibirMedia();
    }
}