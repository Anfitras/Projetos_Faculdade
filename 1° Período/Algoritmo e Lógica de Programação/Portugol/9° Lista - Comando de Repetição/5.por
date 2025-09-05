programa
{
	funcao inicio()
	{
		inteiro numero
		inteiro positivos, negativos, zeros

		positivos = 0
		negativos = 0
		zeros = 0

		enquanto (verdadeiro) {
			escreva("Digite um número (negativo para encerrar): ")
			leia(numero)

			se (numero < 0) {
				negativos = negativos + 1
				pare
			}
			senao se (numero > 0) {
				positivos = positivos + 1
			}
			senao {
				zeros = zeros + 1
			}
		}

		escreva("\nResultados:")
		escreva("\nPositivos: ", positivos)
		escreva("\nZeros: ", zeros)
		escreva("\nNegativos (incluindo o de parada): ", negativos)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 565; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */