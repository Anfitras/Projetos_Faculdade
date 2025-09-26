using System;

class ex06
{
    static void Main()
    {
        int tamanhoVetor, numUsuario;

        Console.Write("Tamanho do vetor: ");
        tamanhoVetor = int.Parse(Console.ReadLine());

        int[] vetor = new int[tamanhoVetor];

        Random rand = new Random();
        for (int i = 0; i < tamanhoVetor; i++)
        {
            vetor[i] = rand.Next(0, 100);
        }

        Console.WriteLine("--- Vetor ---");

        for (int i = 0; i < tamanhoVetor; i++)
        {
            Console.Write(vetor[i] + "|");
        }

        Console.WriteLine();

        while (true)
        {
            int confirm = 0;
            int pos = 0;

            Console.WriteLine("Digite um valor: ");
            numUsuario = int.Parse(Console.ReadLine());

            for (int i = 0; i < tamanhoVetor; i++)
            {
                if (numUsuario == vetor[i])
                {
                    confirm = 1;
                    pos = i;
                }
            }

            if (confirm == 1)
            {
                Console.WriteLine($"Este valor está no vetor! Na posição {pos}°.");
            }
            else
            {
                Console.WriteLine("Este valor não está no vetor!");
            }

        }
    }
}