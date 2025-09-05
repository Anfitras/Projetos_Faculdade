programa
{
	
	funcao inicio()
	{
		inteiro n1, n2, n3, troca

		escreva("Escolha um número: ")
		leia(n1)
		escreva("Escolha outro número: ")
		leia(n2)
		escreva("Escolha outro número: ")
		leia(n3)

		se (n1 > n3){
			troca = n1
			n1 = n3
			n3 = troca
		}
		se (n2 > n3){
			troca = n2
			n2 = n3
			n3 = troca
		}
		se (n1 > n2){
			troca = n1
			n1 = n2
			n2 = troca
		}
		
		escreva(n1,"\n",n2,"\n",n3)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 348; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */