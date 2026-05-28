import java.time.LocalDate;

public class Emprestimo {
    private Livro livro;
    private Leitor leitor;
    private LocalDate dataEmprestimo;
    private LocalDate dataDevolucao;

    public Emprestimo(Livro livro, Leitor leitor, LocalDate dataEmprestimo) {
        this.livro = livro;
        this.leitor = leitor;
        this.dataEmprestimo = dataEmprestimo;
    }

    public Livro getLivro() {
        return livro;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucao() {
        return dataDevolucao;
    }

    public void registrarDevolucao(LocalDate dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public boolean estaAtivo() {
        return dataDevolucao == null;
    }

    public void imprimirDadosEmprestimo() {
        System.out.printf("Livro: %s%n", livro.getTitulo());
        System.out.printf("Leitor: %s%n", leitor.getNome());
        System.out.printf("Data do emprestimo: %s%n", dataEmprestimo);
        System.out.printf("Data da devolucao: %s%n", dataDevolucao);
        System.out.printf("Status: %s%n", estaAtivo() ? "ATIVO" : "DEVOLVIDO");
    }

    @Override
    public String toString() {
        return "Emprestimo{livro='" + livro.getTitulo() + "', leitor='" + leitor.getNome()
                + "', dataEmprestimo=" + dataEmprestimo + ", dataDevolucao=" + dataDevolucao + "}";
    }
}
