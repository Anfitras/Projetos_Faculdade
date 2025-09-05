programa
{
	funcao inicio()
	{
		inteiro i, numero
		inteiro somaMult3, somaMult5

		somaMult3 = 0
		somaMult5 = 0
		i = 1

		enquanto (i <= 20) {
			escreva("Digite o ", i, "º número: ")
			leia(numero)

			se (numero % 3 == 0) {
				somaMult3 = somaMult3 + numero
			}

			se (numero % 5 == 0) {
				somaMult5 = somaMult5 + numero
			}

			i = i + 1
		}

		escreva("Soma dos múltiplos de 3: ", somaMult3, "\n")
		escreva("Soma dos múltiplos de 5: ", somaMult5, "\n")
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 474; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */