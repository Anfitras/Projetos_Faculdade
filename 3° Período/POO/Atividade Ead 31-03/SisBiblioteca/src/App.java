import java.time.LocalDate;

public class App {
    public static void main(String[] args) {
        Autor autor = new Autor("Machado de Assis", "machado@email.com", "Importante escritor brasileiro.");
        Leitor leitor = new Leitor("Ana Silva", "ana@email.com", "2026001");

        Livro livro = new Livro("Dom Casmurro", autor, 1899);

        Biblioteca biblioteca = new Biblioteca("Biblioteca Central");
        biblioteca.adicionarLivro(livro);

        Emprestimo emprestimo = biblioteca.emprestarLivro(livro, leitor, LocalDate.now());
        imprimirSecao("EMPRESTIMO REALIZADO");
        emprestimo.imprimirDadosEmprestimo();

        biblioteca.devolverLivro(emprestimo, LocalDate.now().plusDays(7));
        imprimirSecao("EMPRESTIMO FINALIZADO");
        emprestimo.imprimirDadosEmprestimo();
    }

    private static void imprimirSecao(String titulo) {
        System.out.printf("%n---- %s ----%n", titulo);
    }
}
