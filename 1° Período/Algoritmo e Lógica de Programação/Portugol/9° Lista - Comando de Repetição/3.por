programa
{
	funcao inicio()
	{
		inteiro numero

		enquanto (verdadeiro) {
			escreva("Digite um número (0 para terminar): ")
			leia(numero)

			se (numero == 0) {
				pare
			}

			escreva("Representação binária: ")
			converterParaBinario(numero)
			escreva("\n")
		}
	}

	funcao converterParaBinario(inteiro n)
	{
		se (n == 0) {
			escreva("0")
			retorne
		}

		cadeia binario = ""

		enquanto (n > 0) {
			binario = (n % 2) + binario
			n = n / 2
		}

		escreva(binario)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 483; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */