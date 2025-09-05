programa
{
	funcao inicio()
	{
		inteiro linhaEstrela, colunaEstrela
		inteiro linha, coluna

		escreva("Digite a linha da estrela (1 a 3): ")
		leia(linhaEstrela)

		escreva("Digite a coluna da estrela (1 a 5): ")
		leia(colunaEstrela)

		se (linhaEstrela < 1 ou linhaEstrela > 3 ou colunaEstrela < 1 ou colunaEstrela > 5) {
			escreva("Posição inválida! Linha deve ser de 1 a 3 e coluna de 1 a 5.")
		}
		senao {
			linha = 1
			enquanto (linha <= 3) {
				coluna = 1
				enquanto (coluna <= 5) {
					se (linha == linhaEstrela e coluna == colunaEstrela) {
						escreva("*")
					}
					senao {
						escreva(".")
					}
					coluna = coluna + 1
				}
				escreva("\n")
				linha = linha + 1
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 709; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */