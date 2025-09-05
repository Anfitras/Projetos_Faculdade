programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real volume, altura, raio

		escreva("Qual é a altura da lata em metros?: ")
		leia(altura)
		escreva("E qual é o raio da lata em metros?: ")
		leia(raio)

		volume = mat.arredondar(3.14159 * (raio / 2 * altura),2)

		escreva("O volume dessa lata é ", volume, " m³.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 291; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */