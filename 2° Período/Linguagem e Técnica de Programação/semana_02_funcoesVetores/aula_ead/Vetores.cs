using System;

class Vetores
{
    static void Main()
    {
        int[] notas = new int[5];

        for (int i = 0; i < notas.Length; i++)
        {
            Console.Write($"Digite a {i + 1}° nota: ");
            notas[i] = int.Parse(Console.ReadLine());
        }

        for (int i = 0; i < notas.Length; i++)
        {
            Console.WriteLine($"{i + 1}° nota = {notas[i]}");
        }
    }
}