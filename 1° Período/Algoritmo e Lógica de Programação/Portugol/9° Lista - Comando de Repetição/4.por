programa
{
	funcao inicio()
	{
		inteiro N, a, b, i, proximo

		escreva("Digite o valor de N (número de termos da sequência de Fibonacci): ")
		leia(N)

		se (N <= 0) {
			escreva("Valor inválido. N deve ser um número positivo.")
			retorne
		}

		a = 0
		b = 1

		escreva("Sequência de Fibonacci: ")

		para (i = 1; i <= N; i++) {
			escreva(a, " ")

			proximo = a + b
			a = b
			b = proximo
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 404; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */