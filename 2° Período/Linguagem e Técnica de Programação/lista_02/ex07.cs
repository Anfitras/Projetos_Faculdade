using System;
using System.Reflection.Metadata;
using MinhaBiblioteca;

class ex07
{
    public static void gerarMatriz(double[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        Random rand = new Random();

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz[i, j] = rand.NextDouble() * 100;
            }
        }
    }

    static double[,] alterA(double[,] matriz1, double[,] matriz2, double[,] matriz3)
    {
        int linhas = matriz1.GetLength(0);
        int colunas = matriz1.GetLength(1);

        matriz3 = new double[linhas, colunas];

        Console.WriteLine();
        Console.WriteLine("Somando...");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz3[i, j] = matriz1[i, j] + matriz2[i, j];
            }
        }

        return matriz3;
    }

    static double[,] alterB(double[,] matriz1, double[,] matriz2, double[,] matriz3)
    {
        int linhas = matriz1.GetLength(0);
        int colunas = matriz1.GetLength(1);

        matriz3 = new double[linhas, colunas];

        Console.WriteLine();
        Console.WriteLine("Subtraindo...");

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz3[i, j] = matriz1[i, j] - matriz2[i, j];
            }
        }

        return matriz3;
    }

    static void alterC(double[,] matriz1, double[,] matriz2)
    {
        int linhas = matriz1.GetLength(0);
        int colunas = matriz2.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz1[i, j] = matriz1[i, j] + matriz2[i, j];
            }
        }
    }

    public static void escreverMatriz(double[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                Console.Write($"{matriz[i, j],6:F1} |");
            }
            Console.WriteLine();
        }
    }

    static void Main()
    {
        int linhas, colunas;

        Console.Write("Quantidade de linha das matrizes: ");
        linhas = int.Parse(Console.ReadLine());
        Console.Write("Quantidade de colunas das matrizes: ");
        colunas = int.Parse(Console.ReadLine());

        double[,] matriz1 = new double[linhas, colunas];
        gerarMatriz(matriz1);
        double[,] matriz2 = new double[linhas, colunas];
        gerarMatriz(matriz2);
        double[,] matriz3 = new double[linhas, colunas];

        char resposta;

        bool gerou3Matriz = false;

        do
        {
            Console.WriteLine();
            Console.WriteLine("Você planeja: ");
            Console.WriteLine("a) Somar as duas matrizes.");
            Console.WriteLine("b) Subtrair a primeira matriz da segunda.");
            Console.WriteLine("c) Adicionar uma constante as duas matrizes.");
            Console.WriteLine("d) Imprimir as matrizes.");
            Console.WriteLine("x) Encerrar.");
            Console.Write("Alternativa: ");
            resposta = char.Parse(Console.ReadLine());

            if (resposta != 'a' && resposta != 'b' && resposta != 'c' && resposta != 'd' && resposta != 'x')
            {
                Console.WriteLine();
                Console.WriteLine($"'{resposta}' é uma alternativa Inválida! Tente novamente.");
                continue;
            }

            if (resposta == 'a')
            {
                matriz3 = alterA(matriz1, matriz2, matriz3);
                gerou3Matriz = true;
            }

            if (resposta == 'b')
            {
                matriz3 = alterB(matriz1, matriz2, matriz3);
                gerou3Matriz = true;
            }

            if (resposta == 'c')
            {
                alterC(matriz1, matriz2);
            }

            if (resposta == 'd')
            {
                if (gerou3Matriz == true)
                {
                    Console.WriteLine();
                    Console.WriteLine("--- Matriz 1 ---");
                    escreverMatriz(matriz1);
                    Console.WriteLine();
                    Console.WriteLine("--- Matriz 2 ---");
                    escreverMatriz(matriz2);
                    Console.WriteLine();
                    Console.WriteLine("--- Matriz 3 ---");
                    escreverMatriz(matriz3);
                }
                else
                {
                    Console.WriteLine();
                    Console.WriteLine("--- Matriz 1 ---");
                    escreverMatriz(matriz1);
                    Console.WriteLine();
                    Console.WriteLine("--- Matriz 2 ---");
                    escreverMatriz(matriz2);
                }

            }
        } while (resposta != 'x');

    }
}