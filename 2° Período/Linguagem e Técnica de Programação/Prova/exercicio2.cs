using System;
//Arthur Beraldo (T1)
class exercicio2
{
	static void carregarArquivo(double[] vetor, string nomeArquivo = "temp.txt")
    {
        string dados;
        try
        {
            dados = System.IO.File.ReadAllText(nomeArquivo);
        }
        catch (Exception ex)
        {
            Console.WriteLine("Erro ao ler o arquivo: " + ex.Message);
            return;
        }
       
	   string[] elementos = dados.Split(';');
        int tamanho = vetor.Length;

        for (int i = 0; i < tamanho && i < elementos.Length; i++)
        {
            vetor[i] = double.Parse(elementos[i].Trim());
        }
    }
	
	static void mostrarVetor(double[] vetor)
    {
        int tamanho = vetor.Length;
        Console.WriteLine("*** Vetor de Temperaturas ***");
        for (int i = 0; i < tamanho; i++)
        {
            Console.Write($"{vetor[i]:F2} ");
        }
        Console.WriteLine();
    }
	
	static double mediaTemp(double[] vetor)
	{
		int tamanho = vetor.Length;
		double soma = 0.0;
		
		for (int i = 0; i < tamanho; i++)
		{
			soma += vetor[i];
		}
		
		double media = (soma / vetor.Length);
		
		return media;
	}
	
	static int diasEntreTemp(double[] vetor)
	{
		int tamanho = vetor.Length;
		int totalDias = 0;
		
		for (int i = 0; i < tamanho; i++)
		{
			if (vetor[i] >= 22.0 && vetor[i] <= 25.0)
			{
				totalDias++;
			}
		}
		
		return totalDias;
	}
		
	static void Main()
	{
		double[] clima = new double[30];
		
		carregarArquivo(clima);
		
		mostrarVetor(clima);
		
		double mediaTemperatura = mediaTemp(clima);
		
		Console.WriteLine($"Média mensal das temperaturas: {mediaTemperatura:F2}");
		
		if (mediaTemperatura > 22.0)
		{
			Console.WriteLine("Alerta de temperatura média mensal - maior que 22 graus");
		}
		
		Console.WriteLine($"Total de dias com temperatura entre 22 e 25 graus: {diasEntreTemp(clima)}");
		
	}
}