programa
{
	
	funcao inicio()
	{
		inteiro num

		escreva("Número de Atendimento: ")
		leia(num)

		se (num >= 50 e num <= 100){
			escreva("Guiche A")
		}
		senao se (num >= 25 e num <= 49){
			escreva("Guiche B")
		}
		senao se (num >= 10 e num <= 24){
			escreva("Guiche C")
		}
		senao{
			escreva("Guiche D ou E")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 234; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */