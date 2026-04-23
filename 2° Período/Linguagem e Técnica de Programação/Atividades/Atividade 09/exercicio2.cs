using System;
// Arthur Beraldo (Pré-Prova T2)

class exercicio2
{
	static void gerarMatriz(int[,] matriz)
	{
		int linhas = matriz.GetLength(0);
		int cols = matriz.GetLength(1);
		Random rand = new Random();

		for (int i = 0; i < linhas; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				matriz[i, j] = rand.Next(2);
			}
		}
	}
	static void mostrarMatriz(int[,] matriz)
	{
		int linhas = matriz.GetLength(0);
		int cols = matriz.GetLength(1);
		for (int i = 0; i < linhas; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				Console.Write($"{matriz[i, j],2} | ");
			}
			Console.WriteLine();
		}
	}

	static int areaOcupada(int[,] matriz)
	{
		int linhas = matriz.GetLength(0);
		int cols = matriz.GetLength(1);
		int soma = 0;

		for (int i = 0; i < linhas; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				soma += matriz[i, j];
			}
		}

		return soma;
	}

	static void Main()
	{
		Console.Write("Tamnho da area[LinhasxColunas]:");
		string linhasColunas = Console.ReadLine();

		string[] linhas_colunas = linhasColunas.Split(' ');

		int linhas = int.Parse(linhas_colunas[0]);
		int colunas = int.Parse(linhas_colunas[1]);

		int[,] matriz1 = new int[linhas, colunas];
		int[,] matriz2 = new int[linhas, colunas];

		gerarMatriz(matriz1);
		Console.WriteLine("Matriz Anterior");
		mostrarMatriz(matriz1);

		gerarMatriz(matriz2);
		Console.WriteLine("Matriz Atual");
		mostrarMatriz(matriz2);

		Console.WriteLine($"Area ocupação Anterior X Atual: {areaOcupada(matriz1)} X {areaOcupada(matriz2)}");

		double percent1 = areaOcupada(matriz1) * 100.0 / (linhas * colunas);
		double percent2 = areaOcupada(matriz2) * 100.0 / (linhas * colunas);

		Console.WriteLine($"Pecentual área ocupada Anterior X Atual: {percent1:F2} X {percent2:F2}");

		if (percent1 < percent2)
		{
			double diferenca = percent2 - percent1;
			Console.WriteLine($"Houve um aumento de {diferenca:F2} por cento na ocupação");
		}

		else if (percent1 > percent2)
		{
			double diferenca = percent1 - percent2;
			Console.WriteLine($"Houve uma diminuição de {diferenca:F2} por cento na ocupação");
		}
		else
			Console.WriteLine("Não ouve mudanças na ocupação");

	}
}