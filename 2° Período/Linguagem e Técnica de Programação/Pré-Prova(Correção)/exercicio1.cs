using System;

class exercicio1
{
    static bool pertence(string sequencia)
    {
        bool contem = false;

        for (int i = 0; i < sequencia.Length - 2; i++)
        {
            if (sequencia[i] == 'T' && sequencia[i + 1] == 'A' && sequencia[i + 2] == 'A')
            {
                contem = true;
                break;
            }
        }

        return contem;
    }
    static void Main()
    {
        while (true)
        {
            Console.Clear();

            Console.Write("Sequência: ");
            string sequencia = Console.ReadLine().ToUpper();

            if (sequencia == "SAIR")
            {
                break;
            }

            bool sequenciaValida = true;

            for (int i = 0; i < sequencia.Length; i++)
            {
                if (sequencia[i] != 'A' && sequencia[i] != 'T' && sequencia[i] != 'C' && sequencia[i] != 'G')
                {
                    sequenciaValida = false;
                    break;
                }
            }

            if (sequenciaValida == false)
            {
                Console.WriteLine("Sequência Inválida! Tente novamente.");
                Thread.Sleep(2000);
                continue;
            }

            if (pertence(sequencia) == true)
                Console.WriteLine("A sequência \"TAA\" está dentro da sequência!");

            else
                Console.WriteLine("A sequência \"TAA\" NÃO está dentro da sequência!");

            Thread.Sleep(2000);


        }

    }
}