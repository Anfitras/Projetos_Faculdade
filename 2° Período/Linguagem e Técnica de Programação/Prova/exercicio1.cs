using System;
// Arthur Beraldo (T1)
class exercicio1
{
	static void carregarArquivo(int[,] matriz, string nomeArquivo = "mapa.txt")
    {
        string[] dados;
        try
        {
            dados = System.IO.File.ReadAllLines(nomeArquivo);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Erro ao ler o arquivo: " + ex.Message);
            return;
        }
        int numLinhas = matriz.GetLength(0);
        int numCols = matriz.GetLength(1);
        for (int i = 0; i < numLinhas && i < dados.Length; i++)
        {
            string[] linha = dados[i].Split(',');
            for (int j = 0; j < numCols && j < linha.Length; j++)
            {
                matriz[i, j] = int.Parse(linha[j]);
            }
        }
    }
	
	static void mostrarMatriz(int[,] matriz)
    {
        int linhas = matriz.GetLength(0);
        int cols = matriz.GetLength(1);
        Console.WriteLine("*** Matriz  de Marte ***");
        for (int i = 0; i < linhas; i++)
        {
            for (int j = 0; j < cols; j++)
            {
                Console.Write($"{matriz[i, j],2} | ");
            }
            Console.WriteLine();
        }
    }
	
	static int passosAoMineral(int[,] matriz)
	{	
		int passos = 0;
		int totalPassos = 0;
		int linhas = matriz.GetLength(0);
		int cols = matriz.GetLength(1);
		int linhaParaPular = 0;
		bool achou = false;
		
		for (int i = 0; i < linhas; i++)
		{
			for (int j = linhaParaPular; j < cols; j++)
			{
				Console.WriteLine($"Analisando posição [{i},{j}]");
				passos++;
				
				if(matriz[i,j] == 2)
				{
					Console.WriteLine($"Indício encontrado na posição [{i},{j}], descendo para o sul");
					linhaParaPular = j + 1;
					break;
				}
				else if(matriz[i,j] == 5)
				{
					Console.WriteLine($"Amostra rara encontrado na posição [{i},{j}]");
					totalPassos = passos;
					achou = true;
					break;
				}
				
				linhaParaPular = 0;
			}
			
			if (achou == true)
			{
				break;
			}
		}
		
		if (achou == false)
		{
			totalPassos = -1;
		}
		
		return totalPassos;
	}
	
	static void Main()
	{
		{
			int[,] matriz = new int [5,5];
			carregarArquivo(matriz);
			mostrarMatriz(matriz);
			
			int totalPassos = passosAoMineral(matriz);
			
			if (totalPassos == -1)
			{
				Console.WriteLine("Mineral raro não encontrado");
			}
			else
			{
				Console.WriteLine($"Total de passsos: {totalPassos}");
			}
		}
	}
}