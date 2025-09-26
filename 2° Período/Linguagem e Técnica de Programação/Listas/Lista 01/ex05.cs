using System;

class ex05
{
    static void Main()
    {
        string fitaDNA;

        Console.Write("Digite a fita de dna: ");
        fitaDNA = Console.ReadLine();

        if (fitaDNA.Length > 50)
        {
            Console.Write("Fita de DNA muito grande!");
            return;
        }


        string fitaDNAMaiuscula = fitaDNA.ToUpper();

        char[] baseDNA = fitaDNAMaiuscula.ToArray();

        string baseDNA_Nova = "";


        for (int i = 0; i < baseDNA.Length; i++)
        {
            if (baseDNA[i] != 'A' && baseDNA[i] != 'C' && baseDNA[i] != 'T' && baseDNA[i] != 'G')
            {
                Console.WriteLine($"{baseDNA[i]} é uma base de DNA inválida!");
                return;
            }

            if (baseDNA[i] == 'A')
            {
                baseDNA_Nova += "T";
            }

            else if (baseDNA[i] == 'T')
            {
                baseDNA_Nova += "A";
            }
            else if (baseDNA[i] == 'C')
            {
                baseDNA_Nova += "G";
            }
            else
            {
                baseDNA_Nova += "C";
            }
        }

        Console.WriteLine(baseDNA_Nova);

    }
}