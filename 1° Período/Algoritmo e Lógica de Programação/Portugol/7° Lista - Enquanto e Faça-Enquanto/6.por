programa
{
	
	funcao inicio()
	{
		inteiro valor

		escreva("Digite um valor positivo: ")
		leia(valor)

		se (valor % 2 == 0){
			valor = valor + 1
		}

		enquanto (valor > 3){
			valor = valor - 2
			escreva(valor,"\n")
		
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 180; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */