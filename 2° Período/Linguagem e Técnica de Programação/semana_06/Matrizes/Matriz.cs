using System;

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

        Console.Write("Entre com os dados da matriz: ");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                Console.Write($"[{i},{j}]: ");
                matriz[i, j] = int.Parse(Console.ReadLine());
            }
        }

        Console.WriteLine("--- Matriz ---");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                Console.WriteLine(matriz[i,j]);
            }
        }
    }
}