programa
{
	
	funcao inicio()
	{
		inteiro dias
		real km, preco

		escreva("Por quantos dias você alugou o carro?: ")
		leia(dias)
		escreva("E quantos kilometros você andou com o carro?: ")
		leia(km)

		preco = (60 * dias) + (0.15 * km)

		escreva("O preço total do aluguel é de R$ ",preco) 
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 297; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */