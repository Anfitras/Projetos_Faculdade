using System;
using MinhaBiblioteca;

class Program
{
    static void TotalPessoas(int[,] matriz)
    {
        int total = 0;
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                total += matriz[i, j];
            }
        }

        Console.WriteLine($"Total de pessoas: {total}");
    }

    static void TotalPessoasBairro(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int totalPessoas = 0;

        for (int i = 0; i < linhas; i++)
        {
            totalPessoas = 0;
            for (int j = 0; j < colunas; j++)
            {
                totalPessoas += matriz[i, j];
            }
            Console.WriteLine($"Total de pessoas no {i + 1}° bairro: {totalPessoas}");
        }
    }
    static void TotalPessoasRegiao(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int totalPessoas = 0;

        for (int j = 0; j < colunas; j++)
        {
            totalPessoas = 0;
            for (int i = 0; i < linhas; i++)
            {
                totalPessoas += matriz[i, j];
            }
            Console.WriteLine($"Total de pessoas na {j + 1}° região: {totalPessoas}");
        }
    }
    static void BairroMaisPopuloso(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int totalPessoas = 0;
        int maior = 0;
        int posicao = 0;

        for (int i = 0; i < linhas; i++)
        {
            totalPessoas = 0;
            for (int j = 0; j < colunas; j++)
            {
                totalPessoas += matriz[i, j];
            }

            if (maior < totalPessoas)
            {
                maior = totalPessoas;
                posicao = i;
            }
        }

        Console.WriteLine();
        Console.WriteLine($"O bairro mais populoso é o {posicao + 1}° bairro.");
    }
    static void RegiaoMaisPopulosa(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int totalPessoas = 0;
        int maior = 0;
        int posicao = 0;

        for (int j = 0; j < colunas; j++)
        {
            totalPessoas = 0;
            for (int i = 0; i < linhas; i++)
            {
                totalPessoas += matriz[i, j];
            }

            if (maior < totalPessoas)
            {
                maior = totalPessoas;
                posicao = j;
            }
        }
        Console.WriteLine();
        Console.WriteLine($"A região mais populosa é a {posicao + 1}° região.");
    }
    static void Main()
    {
        int linhas, colunas;

        Console.WriteLine("Quantide de linhas e colunas: ");
        linhas = int.Parse(Console.ReadLine());
        colunas = int.Parse(Console.ReadLine());

        int[,] matriz = new int[linhas, colunas];

        Biblioteca.gerarMatriz(matriz);
        Biblioteca.escreverMatriz(matriz);
        Console.WriteLine();
        TotalPessoas(matriz);
        Console.WriteLine();
        TotalPessoasBairro(matriz);
        Console.WriteLine();
        TotalPessoasRegiao(matriz);
        BairroMaisPopuloso(matriz);
        RegiaoMaisPopulosa(matriz);


    }
}