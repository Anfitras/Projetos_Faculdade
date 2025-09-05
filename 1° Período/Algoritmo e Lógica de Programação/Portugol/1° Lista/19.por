programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real raio, area

		escreva("Qual o raio do círculo em centímetros?: ")
		leia(raio)

		area = 3.14 * mat.potencia(raio,2)

		escreva("A área do círculo é ", area, " cm²")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 246; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */