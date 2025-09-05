programa
{
	
	funcao inicio()
	{
		inteiro valor, contador, multi

		valor = 1

		enquanto (valor > 0)
		{
			escreva("Digite um valor para descobrir a tabuada: ")
			leia(valor)

			para (contador = 1; contador <= 10; contador++)
			{
				multi = valor * contador
				escreva(valor, " x ", contador, " = ", multi, "\n")
			}
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 12; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */