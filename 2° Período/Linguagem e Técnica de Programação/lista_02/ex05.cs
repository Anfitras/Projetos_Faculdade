using System;
using MinhaBiblioteca;

class ex05
{
    static void diagonalSecundaria(int[,] matriz)
    {
        int n = matriz.GetLength(0);

        Console.WriteLine("----- Diagonal Principal -----");

        for (int i = 0; i < n; i++)
        {
            Console.Write(matriz[i, n - 1 - i] + " ");
        }
    }

    static void Main()
    {
        int linhas, colunas;

        Console.Write("Quantidade de linhas e colunas: ");
        linhas = int.Parse(Console.ReadLine());

        colunas = linhas;

        int[,] matriz = new int[linhas, colunas];

        Biblioteca.gerarMatriz(matriz);
        Biblioteca.escreverMatriz(matriz);

        diagonalSecundaria(matriz);

    }
}