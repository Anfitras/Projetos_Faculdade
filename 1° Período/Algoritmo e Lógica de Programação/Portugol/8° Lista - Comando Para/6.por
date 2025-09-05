programa
{
	
	funcao inicio()
	{
		inteiro infe, supe, soma

		escreva("Qual o limite inferior: ")
		leia(infe)

		escreva("Qual o limite superior: ")
		leia(supe)

		se (infe % 2 != 0){
			infe = infe - 1
		}

		para (infe = infe + 2; infe < supe; infe = infe + 2){
			escreva(infe, "\n")
		}
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 299; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */