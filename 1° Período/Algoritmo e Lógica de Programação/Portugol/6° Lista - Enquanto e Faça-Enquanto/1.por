programa
{
	funcao inicio()
	{
		inteiro numero, maior

		escreva("Digite um número (0 para sair): ")
		leia(numero)

		maior = numero

		enquanto (numero != 0)
		{

			se (numero > maior)
			{
				maior = numero
			}
			
			escreva("Digite um número (0 para sair): ")
			leia(numero)
		}

		escreva("O maior número digitado foi: ", maior)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 338; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */