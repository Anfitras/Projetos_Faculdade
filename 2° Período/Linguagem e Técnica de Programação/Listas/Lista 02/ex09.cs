using System;
using MinhaBiblioteca;

class ex09
{
    static void Main()
    {
        int linhas, cols;
        int xi, xf, yi, yf;
        int quantidadeRedes;
        Console.Write("Entre com a quantidade de linhas e colunas:");
        linhas = int.Parse(Console.ReadLine());
        cols = int.Parse(Console.ReadLine());
        int[,] matrixMar = new int[linhas, cols];

        Console.Write("Entre com a quantidade de redes:");
        quantidadeRedes = int.Parse(Console.ReadLine());

        for (int cont = 1; cont <= quantidadeRedes; cont++)
        {

            Console.WriteLine($"--- Entre com as coordenadas da rede {cont} ---");
            Console.WriteLine("Xi e Xf");
            xi = int.Parse(Console.ReadLine());
            xf = int.Parse(Console.ReadLine());

            Console.WriteLine("Yi e Yf");
            yi = int.Parse(Console.ReadLine());
            yf = int.Parse(Console.ReadLine());

            for (int i = xi; i <= xf; i++)
                for (int j = yi; j <= yf; j++)
                    matrixMar[i, j] = 1;

        }

        double area = 0.0;
        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                area += matrixMar[i, j];
            }
        }

        Console.WriteLine(area);

        int areaTotal = linhas * cols;
        double percent;

        percent = area * 100 / areaTotal;

        Console.WriteLine();

        Console.WriteLine($"{percent}%");


    }

}