programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real cigarros, anos, perda, dias

		escreva("Quantos cigarros você fuma por dia?: ")
		leia(cigarros)
		escreva("Há quantos anos você fuma?: ")
		leia(anos)

		anos = anos * 365

		perda = cigarros * 10 * anos

		dias = mat.arredondar(perda / 1440,1)

		escreva("Você já perdeu ",dias," dias de vida por conta do cigarro!")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 327; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */