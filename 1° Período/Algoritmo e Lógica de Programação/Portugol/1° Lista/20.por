programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real a,b,c,d,E, x, px
		
		escreva("Qual será o coeficiente A?: ")
		leia(a)
		escreva("Qual será o coeficiente B?: ")
		leia(b)
		escreva("Qual será o coeficiente C?: ")
		leia(c)
		escreva("Qual será o coeficiente D?: ")
		leia(d)
		escreva("Qual será o coeficiente E?: ")
		leia(E)

		escreva("Qual será o valor de x?: ")
		leia(x)

		px = mat.potencia(a*x,4) + mat.potencia(b*x,3) + mat.potencia(c*x,2) + (d*x) + E

		escreva (px)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 118; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */