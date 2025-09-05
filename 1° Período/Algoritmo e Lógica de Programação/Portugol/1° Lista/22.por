programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real al, razao, termogeral
		inteiro termo

		escreva("Qual será o 1° termo da P.G?: ")
		leia(al)
		escreva("Qual será a razão da P.G?: ")
		leia(razao)
		escreva("Qual termo você quer descobrir?: ")
		leia(termo)

		termogeral = al * mat.potencia(razao,termo-1)

		escreva("O termo geral da P.G dado o ",termo,"° termo é ",termogeral)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 119; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */