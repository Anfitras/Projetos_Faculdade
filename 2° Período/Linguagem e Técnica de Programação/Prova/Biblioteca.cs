using System;
using System.Linq.Expressions;

namespace MinhaBiblioteca
{
    class Biblioteca
    {
        public static void carregarArquivo(int[,] matriz, string nomeArquivo = "mapa.txt")
        {
            string[] dados;
            try
            {
                dados = System.IO.File.ReadAllLines(nomeArquivo);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Erro ao ler o arquivo: " + ex.Message);
                return;
            }
            int numLinhas = matriz.GetLength(0);
            int numCols = matriz.GetLength(1);
            for (int i = 0; i < numLinhas && i < dados.Length; i++)
            {
                string[] linha = dados[i].Split(',');
                for (int j = 0; j < numCols && j < linha.Length; j++)
                {
                    matriz[i, j] = int.Parse(linha[j]);
                }
            }
        }

        public static void lerMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int cols = matriz.GetLength(1);
            Console.WriteLine("Entre com os dados da matriz:");
            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    Console.Write($"[{i},{j}]:");
                    matriz[i, j] = int.Parse(Console.ReadLine());
                }// fim for j
            }// fim for i
        }
        public static void gerarMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int cols = matriz.GetLength(1);
            Random rand = new Random();  // criando o gerador de aleatorios
            Console.WriteLine("Gerando matriz...");
            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    matriz[i, j] = rand.Next(100);
                }// fim for j
            }// fim for i
        }

        public static void mostrarMatriz(int[,] matriz)
        {
            int linhas = matriz.GetLength(0);
            int cols = matriz.GetLength(1);
            Console.WriteLine("*** Matriz ***");
            for (int i = 0; i < linhas; i++)
            {
                for (int j = 0; j < cols; j++)
                {
                    Console.Write($"{matriz[i, j],2} | ");
                }// fim for j
                Console.WriteLine();
            }// fim for i
        }
        public static void mostrarVetor(double[] vetor)
        {
            int tamanho = vetor.Length;
            Console.WriteLine("*** Vetor ***");
            for (int i = 0; i < tamanho; i++)
            {
                Console.Write($"{vetor[i]:F2} ");
            }
            Console.WriteLine();
        }
                public static void carregarArquivo(double[] vetor, string nomeArquivo = "dados.txt")
        {
            string dados;
            try
            {
                dados = System.IO.File.ReadAllText(nomeArquivo);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Erro ao ler o arquivo: " + ex.Message);
                return;
            }

            string[] elementos = dados.Split(';');
            int tamanho = vetor.Length;

            for (int i = 0; i < tamanho && i < elementos.Length; i++)
            {
                vetor[i] = double.Parse(elementos[i].Trim());
            }
        }

    }
    
}