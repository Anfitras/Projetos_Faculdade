programa
{
	inclua biblioteca Matematica
 --> mat
	
	funcao inicio()
	{
		real deposito, taxa, rendimento
		inteiro meses

		escreva("Quantos você planeja depositar por mês?: ")
		leia(deposito)
		escreva("Qual a taxa de rendimento da poupança?: ")
		leia(taxa)
		escreva("Por quantos meses você planeja deixar o seu dinheiro na poupança?: ")
		leia(meses)

		rendimento = mat.arredondar(deposito * (mat.potencia(1 + taxa/100,meses) - 1),2)

		escreva("O rendimento ao longo de ", meses, " meses será de R$ ", rendimento)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 387; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */