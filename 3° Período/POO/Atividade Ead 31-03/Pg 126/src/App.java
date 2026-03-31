public class App {
    public static void main(String[] args) {
        Autor autor1 = new Autor("Machado de Assis");
        Autor autor2 = new Autor("Clarice Lispector");
        Autor autor3 = new Autor("George R. R. Martin");

        Livro livro1 = new Livro("Dom Casmurro", autor1);
        Livro livro2 = new Livro("Memorias Postumas de Bras Cubas", autor1);
        Livro livro3 = new Livro("A Hora da Estrela", autor2);
        Livro livro4 = new Livro("A Guerra dos Tronos", autor3);

        Biblioteca biblioteca1 = new Biblioteca("Biblioteca Central");
        biblioteca1.adicionarLivro(livro1);
        biblioteca1.adicionarLivro(livro2);

        biblioteca1.listarLivros();

        Biblioteca biblioteca2 = new Biblioteca("Biblioteca Regional");
        biblioteca2.adicionarLivro(livro3);
        biblioteca2.adicionarLivro(livro4);

        biblioteca2.listarLivros();
    }
}
