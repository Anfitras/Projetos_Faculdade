programa
{
	
	funcao inicio()
	{
		inteiro valor, produto, soma

		escreva("Digite um valor inteiro e positivo (0 para encerrar): ")
		leia(valor)

		produto = 1
		soma = 0
		
		se (valor > 0){
			enquanto (valor > 0){
				se (valor % 2 == 0){
					soma = soma + valor
				}
				senao{
					produto = produto * valor
				}

				escreva("Digite um valor (0 para encerrar): ")
				leia(valor)
			}
			escreva("O produto dos números ímpares é ",produto,"\nE a soma dos pares é ", soma)
		}
		senao{
			escreva("Número Inválido!")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 526; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */