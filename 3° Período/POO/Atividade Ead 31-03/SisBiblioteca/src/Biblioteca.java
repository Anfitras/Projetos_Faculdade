import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Biblioteca {
    private String nome;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public Biblioteca(String nome) {
        this.nome = nome;
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void removerLivro(Livro livro) {
        livros.remove(livro);
    }

    public List<Livro> getLivros() {
        return Collections.unmodifiableList(livros);
    }

    public List<Emprestimo> getEmprestimos() {
        return Collections.unmodifiableList(emprestimos);
    }

    public Emprestimo emprestarLivro(Livro livro, Leitor leitor, LocalDate dataEmprestimo) {
        if (!livros.contains(livro)) {
            throw new IllegalArgumentException("Livro nao pertence ao acervo da biblioteca.");
        }

        boolean livroEmprestado = emprestimos.stream()
                .anyMatch(e -> e.getLivro().equals(livro) && e.estaAtivo());

        if (livroEmprestado) {
            throw new IllegalStateException("Livro ja esta emprestado.");
        }

        Emprestimo emprestimo = new Emprestimo(livro, leitor, dataEmprestimo);
        emprestimos.add(emprestimo);
        return emprestimo;
    }

    public void devolverLivro(Emprestimo emprestimo, LocalDate dataDevolucao) {
        if (!emprestimos.contains(emprestimo)) {
            throw new IllegalArgumentException("Emprestimo nao encontrado na biblioteca.");
        }

        emprestimo.registrarDevolucao(dataDevolucao);
    }
}
