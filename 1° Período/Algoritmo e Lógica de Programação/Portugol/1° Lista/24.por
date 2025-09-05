programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real rend, dep, tax
		
		escreva("Quanto você depositou/irá depositar?: ")
		leia(dep)
		escreva("Qual a taxa de juros desse depósito?: ")
		leia(tax)

		rend = mat.arredondar(dep * tax / 100,2)

		escreva("O rendimento do seu depósito será R$ ",rend, " sua renda total após o depósito será de R$ ", mat.arredondar(dep + rend,2))

		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 405; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */