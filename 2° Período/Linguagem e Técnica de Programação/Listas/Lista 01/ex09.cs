using System;

class ex09
{
    static void Main()
    {
        Console.Write("Digite uma frase: ");
        string frase = Console.ReadLine();

        char[] fraseChar = frase.ToCharArray();

        int tamanho = frase.Length;

        Array.Reverse(fraseChar);

        Console.WriteLine("Frase invertida: " + new string(fraseChar));
        Console.WriteLine("Tamanho do vetor: " + tamanho);
    }
}