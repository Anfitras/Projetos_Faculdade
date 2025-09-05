programa
{
	
	funcao inicio()
	{
		real n1, n2, n3 ,n4, media

		escreva("Nota 1° Prova: ")
		leia(n1)
		escreva("Nota 2° Prova: ")
		leia(n2)
		escreva("Nota 3° Prova: ")
		leia(n3)
		escreva("Nota 4° Prova: ")
		leia(n4)

		media = (n1 + n2 + n3 + n4) / 4

		se (media >= 5){
			escreva("APROVADO! Com uma média de ", media, " pts.")
		}
		senao{
			escreva("REPROVADO! Com uma média de ", media, " pts.")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 412; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */