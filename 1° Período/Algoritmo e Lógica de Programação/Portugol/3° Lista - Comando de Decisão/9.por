programa
{
	
	funcao inicio()
	{
		inteiro n1

		escreva("Escolha um número: ")
		leia(n1)

		se ( n1 % 2 == 0 e n1 % 3 == 0){
			escreva("Seu número é par e divisível por 3!")
		}
		senao se ( n1 % 2 == 0){
			escreva("Seu número é apenas par!")
		}
		senao se ( n1 % 3 == 0){
			escreva("Seu número é apenas divisível por 3!")
		}
		senao{
			escreva("Seu número não é nem par nem divisível por 3!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 406; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */