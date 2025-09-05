programa
{
	funcao inicio()
	{
		inteiro numero, fatorial, contador

		escreva("Digite um número inteiro não negativo: ")
		leia(numero)

		se (numero < 0) {
			escreva("Número inválido. Digite um número maior ou igual a zero.")
		}
		senao {
			fatorial = 1
			contador = numero

			enquanto (contador > 1) {
				fatorial = fatorial * contador
				contador = contador - 1
			}

			escreva("O fatorial de ", numero, " é ", fatorial)
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 442; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */