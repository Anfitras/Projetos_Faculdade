using System;
using MinhaBiblioteca;
class ex01
{
    static int getMin(int[,] matriz)
    {
        int menor = matriz[0, 0];
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                if (menor > matriz[i, j])
                    menor = matriz[i, j];
            }
        }

            return menor;
    }
    static void Main()
    {
        int linhas, colunas;

        Console.WriteLine("Entre com a quantidade de linhas e colunas: ");
        linhas = int.Parse(Console.ReadLine());
        colunas = int.Parse(Console.ReadLine());

        int[,] matriz = new int[linhas, colunas];

        Biblioteca.gerarMatriz(matriz);
        Biblioteca.escreverMatriz(matriz);

        Console.WriteLine("----- Menor -----");

        Console.WriteLine(getMin(matriz));
    }
}