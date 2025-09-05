programa
{
	funcao inicio()
	{
		inteiro N, i

		escreva("Digite o valor de N (limite superior): ")
		leia(N)

		se (N < 2) {
			escreva("Não há números primos nesse intervalo.")
			retorne
		}

		escreva("Números primos entre 1 e ", N, ": ")

		para (i = 2; i <= N; i++) {
			se (ehPrimo(i)) {
				escreva(i, " ")
			}
		}
	}

	funcao logico ehPrimo(inteiro numero)
	{
		inteiro j

		se (numero < 2) {
			retorne falso
		}

		para (j = 2; j <= numero / 2; j++) {
			se (numero % j == 0) {
				retorne falso
			}
		}

		retorne verdadeiro
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 544; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */