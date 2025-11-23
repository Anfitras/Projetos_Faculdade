namespace cadastroBandas
{
    class Banda
    {
        public string nome;
        public string tipo;
        public int integrantes;
        public int rank;
    }
}

namespace cadastroLivros
{
    class Livro
    {
        public string titulo;
        public string autor;
        public int ano;
        public int prateleira;
    }
}

namespace cadastroEletro
{
    class Eletro
    {
        public string nome;
        public double potencia;
        public double tempoMedio;
    }
}

namespace cadastroJogo
{
    class Emprestimo
    {
        public DateOnly data;
        public string nomePessoa;
        public bool emprestado;
    }

    class Jogo
    {
        public string nome;
        public string console;
        public int rank;

        public List<Emprestimo> listadeEmprestimos = new List<Emprestimo>();
    }
}

namespace cadastroGado
{
    class Data
    {
        public string mes;
        public int ano;
    }

    class Gado
    {
        public int codigo;
        public double leite;
        public double alim;
        public Data data;
        public bool abate;
    }
}
