programa
{
	funcao inicio()
	{
		inteiro anterior, atual
		inteiro tipo

		tipo = 0

		escreva("Digite um número (0 para terminar): ")
		leia(anterior)

		se (anterior == 0) {
			escreva("Sequência vazia.")
			retorne
		}

		enquanto (verdadeiro) {
			escreva("Digite um número (0 para terminar): ")
			leia(atual)

			se (atual == 0) {
				pare
			}

			se (tipo == 0) {
				se (atual > anterior) {
					tipo = 1
				}
				senao se (atual < anterior) {
					tipo = 2
				}
			}
			senao se (tipo == 1 e atual < anterior) {
				tipo = 3
			}
			senao se (tipo == 2 e atual > anterior) {
				tipo = 3
			}

			anterior = atual
		}

		se (tipo == 0) {
			escreva("Todos os números eram iguais ou só tinha um número.")
		}
		senao se (tipo == 1) {
			escreva("Sequência em ordem crescente.")
		}
		senao se (tipo == 2) {
			escreva("Sequência em ordem decrescente.")
		}
		senao {
			escreva("Sequência não ordenada.")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 350; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */