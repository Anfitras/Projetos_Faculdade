using System;
using MinhaBiblioteca;

class ex06
{
    static void somarMatrizes(int[,] matriz1, int[,] matriz2)
    {
        int linhas = matriz1.GetLength(0);
        int colunas = matriz1.GetLength(1);

        int[,] matriz3 = new int[linhas, colunas];

        Console.WriteLine("----- Soma das Matrizes -----");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz3[i, j] = matriz1[i, j] + matriz2[i, j];
                Console.Write($"{matriz3[i, j],3} |");
            }
            Console.WriteLine();
        }
    }
    static void Main()
    {
        int linhasMatriz1, colunasMatriz1, linhasMatriz2, colunasMatriz2;

        Console.WriteLine("Linhas e Colunas (matriz 1): ");
        linhasMatriz1 = int.Parse(Console.ReadLine());
        colunasMatriz1 = int.Parse(Console.ReadLine());
        Console.WriteLine("Linhas e Colunas (matriz 2): ");
        linhasMatriz2 = int.Parse(Console.ReadLine());
        colunasMatriz2 = int.Parse(Console.ReadLine());

        if (linhasMatriz1 != linhasMatriz2 || colunasMatriz1 != colunasMatriz2)
        {
            Console.WriteLine("Ordem das matrizes são diferentes!");
            return;
        }

        int[,] matriz1 = new int[linhasMatriz1, colunasMatriz1];
        int[,] matriz2 = new int[linhasMatriz2, colunasMatriz2];

        Biblioteca.gerarMatriz(matriz1);
        Biblioteca.gerarMatriz(matriz2);

        Biblioteca.escreverMatriz(matriz1);
        Biblioteca.escreverMatriz(matriz2);

        somarMatrizes(matriz1, matriz2);


    }
}