using System;
using MinhaBiblioteca;
class ex03
{
    static int getMax(int[,] matriz, int x)
    {
        int contador = 0;
        int linhas = matriz.GetLength(0);
        int colunas = matriz.GetLength(1);

        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < colunas; j++)
            {
                if (x == matriz[i, j])
                    contador++;
            }
        }

        return contador;
    }
    static void Main()
    {
        int linhas, colunas, x;

        Console.Write("Entre com a quantidade de linhas e colunas: ");
        linhas = int.Parse(Console.ReadLine());
        colunas = int.Parse(Console.ReadLine());
        Console.Write("Valor x: ");
        x = int.Parse(Console.ReadLine());

        int[,] matriz = new int[linhas, colunas];

        Biblioteca.gerarMatriz(matriz);
        Biblioteca.escreverMatriz(matriz);

        Console.WriteLine("----- Aparições de X -----");

        Console.WriteLine(getMax(matriz, x));
    }
}