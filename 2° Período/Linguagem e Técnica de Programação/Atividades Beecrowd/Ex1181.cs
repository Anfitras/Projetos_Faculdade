using System;

class Ex1181
{
    static void Main()
    {
        float[,] matriz = new float[12, 12];

        Console.Write("Qual linha pegar: ");
        int QualLinha = int.Parse(Console.ReadLine());

        Console.Write("Somar ou Média: ");
        char SomaouMedia = char.Parse(Console.ReadLine());
        SomaouMedia = char.ToUpper(SomaouMedia);

        for (int i = 0; i < 12; i++)
        {
            for (int j = 0; j < 12; j++)
            {
                matriz[i, j] = float.Parse(Console.ReadLine());
            }
        }

        if (SomaouMedia == 'S')
        {
            float soma = 0.0f;
            for (int i = 0; i < 12; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (i == QualLinha)
                    {
                        soma += matriz[i, j];
                    }
                }
            }

            Console.WriteLine(soma.ToString("F1"));
        }
        else if (SomaouMedia == 'M')
        {
            float soma = 0.0f;
            int quant = 0;

            for (int i = 0; i < 12; i++)
            {
                for (int j = 0; j < 12; j++)
                {
                    if (i == QualLinha)
                    {
                        soma += matriz[i, j];
                        quant++;
                    }
                }
            }

            float media = soma / quant;

            Console.WriteLine(media.ToString("F1"));
        }
    }
}