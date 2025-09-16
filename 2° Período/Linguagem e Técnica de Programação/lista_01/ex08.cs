using System;

class ex08
{
    static void Main()
    {
        int tamanhoVetor, numEscolhido;
        int contador = 0;

        Console.Write("Tamanho do vetor: ");
        tamanhoVetor = int.Parse(Console.ReadLine());
        Console.Write("Número escolhido: ");
        numEscolhido = int.Parse(Console.ReadLine());

        Random rnd = new Random();

        int[] vetor = new int[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++)
        {
            int random = rnd.Next(1, 101);
            vetor[i] = random;
        }

        for (int i = 0; i < tamanhoVetor; i++)
        {
            if (numEscolhido == vetor[i])
            {
                contador++;
            }
        }

        Console.WriteLine($"O número escolhido -- {numEscolhido} -- apareceu {contador} vezes no vetor: ");

        for (int i = 0; i < tamanhoVetor; i++)
        {
            Console.Write(vetor[i] + " ");
        }

    }
}