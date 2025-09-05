programa
{
	
	funcao inicio()
	{
		inteiro dias, hrs, min, seg, result

		escreva("Quantos dias você trabalhou?: ")
		leia(dias)
		escreva("Quantas horas você trabalhou?: ")
		leia(hrs)
		escreva("Quantos minutos você trabalhou?: ")
		leia(min)
		escreva("Quantos segundos você trabalhou?: ")
		leia(seg)

		dias = (dias * 86400)
		hrs = (hrs * 3600)
		min = (min * 60)
		result = (dias + hrs + min + seg)

		escreva("Você trabalhou ", result, " segundos!")
		
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 263; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */