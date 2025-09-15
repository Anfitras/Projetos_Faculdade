using System;
using MinhaBiblioteca;

class Matriz
{
    static void Main()
    {
        int linhas, colunas;

        Console.Write("Quantidade de linhas: ");
        linhas = int.Parse(Console.ReadLine());
        Console.Write("Quantidade de colunas: ");
        colunas = int.Parse(Console.ReadLine());

        int[,] matriz = new int[linhas, colunas];

        Biblioteca.gerarMatriz(matriz);

        Biblioteca.escreverMatriz(matriz);


    }
}