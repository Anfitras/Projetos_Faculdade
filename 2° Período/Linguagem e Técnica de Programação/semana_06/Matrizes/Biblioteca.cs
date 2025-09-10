using System;

namespace MinhaBiblioteca
{
    class Biblioteca
    {
        public static void lerMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int colunas = matriz.GetLength(1);
            Console.Write("Entre com os dados da matriz: ");
            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < colunas; j++)
                {
                    Console.Write($"[{i},{j}]: ");
                    matriz[i, j] = int.Parse(Console.ReadLine());
                }
            }
        }

        public static void gerarMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int colunas = matriz.GetLength(1);

            Random rand = new Random();

            Console.Write("Gerando matriz...");
            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < colunas; j++)
                {
                    matriz[i, j] = rand.Next(0, 100);
                }
            }
        }

        public static void escreverMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int colunas = matriz.GetLength(1);

            Console.WriteLine("--- Matriz ---");

            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < colunas; j++)
                {
                    Console.Write(matriz[i, j] + " | ");
                }
                Console.WriteLine();
            }
        }
    }
}