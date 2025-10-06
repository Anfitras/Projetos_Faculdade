using System;

class exercicio2
{
    static void gerarMatriz(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        Random rand = new Random();

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                matriz[i, j] = rand.Next(2);
            }
        }
    }

    static void mostrarMatriz(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                Console.Write($" {matriz[i, j]} |");
            }

            Console.WriteLine();
        }
    }

    static int tamanhoAreaCoberta(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int soma = 0;

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                soma += matriz[i, j];
            }
        }

        return soma;
    }

    static double percentualAreaCoberta(int[,] matriz, int soma)
    {
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);
        int total = linhas * colunas;
        double percent = 0.0;

        percent = soma * 100.0 / total;

        return percent;
    }
    static void Main()
    {
        Console.Write("Tamanho da area analisada: ");
        string tamanhos = Console.ReadLine();

        string[] tamanhosSplit = tamanhos.Split(" ");

        int linhas = int.Parse(tamanhosSplit[0]);
        int colunas = int.Parse(tamanhosSplit[1]);

        int[,] matriz1 = new int[linhas, colunas];
        int[,] matriz2 = new int[linhas, colunas];

        gerarMatriz(matriz1);
        gerarMatriz(matriz2);

        Console.WriteLine("Area 06 meses atrás");
        mostrarMatriz(matriz1);
        Console.WriteLine("Area atual");
        mostrarMatriz(matriz2);

        Console.WriteLine("Tamanho da area coberta anterior: " + tamanhoAreaCoberta(matriz1));
        double percent1 = percentualAreaCoberta(matriz1, tamanhoAreaCoberta(matriz1));
        Console.WriteLine($"Percentual area coberta anterior {percent1:F2}");

        Console.WriteLine("Tamanho da area coberta atual: " + tamanhoAreaCoberta(matriz2));
        double percent2 = percentualAreaCoberta(matriz2, tamanhoAreaCoberta(matriz2));
        Console.WriteLine($"Percentual area coberta anterior {percent2:F2}");

        if (percent1 < percent2)
            Console.WriteLine($"Houve uma progressão na cobertura vegetal de {(percent2 - percent1):F2} por cento");

        else if (percent2 < percent1)
            Console.WriteLine($"Houve uma redução na cobertura vegetal de {(percent1 - percent2):F2} por cento");
        else
            Console.WriteLine("Não houve alterações durante os 06 meses");
    }
}