programa
{
	funcao inicio()
	{
		inteiro lado, linha, coluna

		escreva("Digite o tamanho do lado do quadrado (1 a 20): ")
		leia(lado)

		se (lado < 1 ou lado > 20) {
			escreva("Tamanho inválido. Digite um número entre 1 e 20.")
		} 
		senao {
			linha = 1
			enquanto (linha <= lado) {
				coluna = 1
				enquanto (coluna <= lado) {
					escreva("*")
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
 * @POSICAO-CURSOR = 424; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */