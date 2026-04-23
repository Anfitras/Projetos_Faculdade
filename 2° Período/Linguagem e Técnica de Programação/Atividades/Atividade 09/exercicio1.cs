using System;
//Arthur Beraldo (Pré-Prova T2)

class exercicio1
{
	static void Main()
	{
		string sequenciaDNA = Console.ReadLine().ToUpper();
		char[] arrayDeDNA = sequenciaDNA.ToCharArray();
		int tamanho = sequenciaDNA.Length;

		bool contem = false;

		for (int i = 0; i < tamanho - 2; i++)
		{
			if (arrayDeDNA[i] != 'A' && arrayDeDNA[i] != 'T' && arrayDeDNA[i] != 'G' && arrayDeDNA[i] != 'C')
			{
				Console.Write($"{arrayDeDNA[i]} não é uma sequência de DNA válida!");
			}

			if (arrayDeDNA[i] == 'T' && arrayDeDNA[i + 1] == 'A' && arrayDeDNA[i + 2] == 'A')
				contem = true;
		}

		if (contem == true)
			Console.WriteLine("A sequência contém o stop condon 'TAA'.");
		else
			Console.WriteLine("A sequência NÃO contém o stop condon 'TAA'.");

	}
}