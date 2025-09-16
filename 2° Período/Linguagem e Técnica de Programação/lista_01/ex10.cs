using System;

class ex10
{
    static void Main()
    {
        int qntLancamentos;
        int q1 = 0, q2 = 0, q3 = 0, q4 = 0, q5 = 0, q6 = 0;

        Console.Write("Quantidade de lançamentos: ");
        qntLancamentos = int.Parse(Console.ReadLine());

        Random rnd = new Random();

        for (int i = 0; i < qntLancamentos; i++)
        {
            int lado = rnd.Next(1, 7);

            if (lado == 1)
            {
                q1++;
            }
            else if (lado == 2)
            {
                q2++;
            }
            else if (lado == 3)
            {
                q3++;
            }
            else if (lado == 4)
            {
                q4++;
            }
            else if (lado == 5)
            {
                q5++;
            }
            else if (lado == 6)
            {
                q6++;
            }
        }

        Console.WriteLine($"O dado foi lançado {qntLancamentos} vezes, tendo os resultados:");
        Console.WriteLine($"{q1} vezes no n° 1");
        Console.WriteLine($"{q2} vezes no n° 2");
        Console.WriteLine($"{q3} vezes no n° 3");
        Console.WriteLine($"{q4} vezes no n° 4");
        Console.WriteLine($"{q5} vezes no n° 5");
        Console.WriteLine($"{q6} vezes no n° 6");
    }
}