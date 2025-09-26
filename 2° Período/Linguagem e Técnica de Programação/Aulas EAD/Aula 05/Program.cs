using System;

class Program
{
    static void Main()
    {
        string frase;

        Console.Write("Digite uma frase codificada: ");
        frase = Console.ReadLine();

        char[] frase_char = frase.ToArray();

        for (int i = 0; i < frase_char.Length; i++)
        {
            if (frase_char[i] == ' ')
            {
                frase_char[i] = '_';
            }

        }

        frase = new string(frase_char);

        Console.WriteLine(frase_char);
    }
}