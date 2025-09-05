programa
{
	
	funcao inicio()
	{
		inteiro valor
		real media, divisor, dividendo

		escreva("Digite um valor (0 para encerrar): ")
		leia(valor)
		
		divisor = 0
		dividendo = 0

		enquanto (valor != 0)
		{
			se (valor % 2 == 0)
			{
				dividendo = dividendo + valor
				divisor = divisor + 1
			}
			
			escreva("Digite um valor (0 para encerrar): ")
			leia(valor)
		}
		
		media = dividendo / divisor

		escreva("A média dos valores pares é ", media)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 53; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */