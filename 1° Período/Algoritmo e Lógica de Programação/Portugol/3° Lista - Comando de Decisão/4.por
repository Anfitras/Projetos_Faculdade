programa
{
	
	funcao inicio()
	{
		real num1, num2

		escreva("Escolha um número: ")
		leia(num1)
		escreva("Escolha outro número: ")
		leia(num2)

		se (num1 == num2){
			escreva("Os números são iguais!")
		}
		senao se (num1 > num2){
			escreva("O maior é ", num1, " e o menor é ", num2)
		}
		senao{
			escreva("O maior é ", num2, " e o menor é ", num1)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 208; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */