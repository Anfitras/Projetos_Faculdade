programa
{
	
	funcao inicio()
	{
		real prestacao, valor, taxa
		inteiro tempo

		escreva("Qual o valor original da prestação?: ")
		leia(valor)
		escreva("Qual é a porcentagem da taxa aplicada?: ")
		leia(taxa)
		escreva("Quantos meses esse prestação está atrasada?: ")
		leia(tempo)

		prestacao = (valor + (valor * (taxa / 100) * tempo))

		escreva("O novo valor da prestação é R$ ", prestacao)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 409; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */