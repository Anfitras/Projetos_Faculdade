using System;
using MinhaBiblioteca;

class ex10
{
    static void escreverMatriz(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        Console.WriteLine("Matriz das Tropas (Quantidade de Tropas por Cidade): ");

        for (int i = 0; i < linhas; i++)
        {
            Console.Write($"Região {i + 1}: ");
            for (int j = 0; j < colunas; j++)
            {
                Console.Write($"{matriz[i, j],3} ");
            }
            Console.WriteLine();
        }
    }
    static void somarLinhaMatriz(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int[] somaLinha = new int[linhas];

        Console.WriteLine("Força Total das Regiões: ");
        for (int i = 0; i < linhas; i++)
        {
            Console.Write($"Região {i + 1}: ");
            for (int j = 0; j < colunas; j++)
            {
                somaLinha[i] += matriz[i, j];
            }
            Console.WriteLine($"{somaLinha[i]} tropas");
        }

    }
    static void Main()
    {
        int regioes, cidades;

        Console.WriteLine("Quantidade de regiões e cidades: ");
        regioes = int.Parse(Console.ReadLine());
        cidades = int.Parse(Console.ReadLine());

        int[,] matriz = new int[regioes, cidades];
        Console.WriteLine();
        Biblioteca.gerarMatriz(matriz);
        escreverMatriz(matriz);
        Console.WriteLine();
        somarLinhaMatriz(matriz);

    }
}