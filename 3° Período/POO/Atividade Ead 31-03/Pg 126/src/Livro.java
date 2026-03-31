public class Livro {
    private String titulo;
    private Autor autor;

    public Livro(String titulo, Autor autor) {
        this.titulo = titulo;
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    @Override
    public String toString() {
        return "Livro: " + titulo + " | " + autor.getNome();
    }
}
