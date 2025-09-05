programa
{
	funcao inicio()
	{
		inteiro linha, coluna

		linha = 1
		enquanto (linha <= 8) {
			coluna = 1
			enquanto (coluna <= linha) {
				escreva("*")
				coluna = coluna + 1
			}
			escreva("\n")
			linha = linha + 1
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 233; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */