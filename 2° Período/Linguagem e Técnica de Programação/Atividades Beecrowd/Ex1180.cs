using System;

class Ex1180
{
    static void Main()
    {
        int N;

        //Console.WriteLine("Tamanho do vetor: ");
        N = int.Parse(Console.ReadLine());

        int[] vetor = new int[N];

        string[] entrada = Console.ReadLine().Split(' ');

        int menor = int.Parse(entrada[0]);
        int posicao = 0;

        for (int i = 0; i < N; i++)
        {
            vetor[i] = int.Parse(entrada[i]);

            if (vetor[i] < menor)
            {
                menor = vetor[i];
                posicao = i;
            }
        }

        Console.WriteLine($"Menor valor: {menor}");
        Console.WriteLine($"Posicao: {posicao}");
    }
}