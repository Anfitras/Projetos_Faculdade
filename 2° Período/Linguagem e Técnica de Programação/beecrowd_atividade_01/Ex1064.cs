using System;
using System.Globalization;
class Ex1064
{
    static void Main()
    {
        float[] numeros = new float[6];
        float soma = 0.0f;
        float media;
        int contador = 0;

        Console.WriteLine("Digite valores: ");

        for (int i = 0; i < 6; i++)
        {
            numeros[i] = float.Parse(Console.ReadLine(), CultureInfo.CreateSpecificCulture("en-US"));
        }

        for (int i = 0; i < 6; i++)
        {
            if (numeros[i] > 0)
            {
                contador++;
                soma = soma + numeros[i];
            }
        }

        media = soma / contador;

        Console.WriteLine(contador + " valores positivos");
        Console.WriteLine(media.ToString("F1", CultureInfo.CreateSpecificCulture("en-US")));
    }
}