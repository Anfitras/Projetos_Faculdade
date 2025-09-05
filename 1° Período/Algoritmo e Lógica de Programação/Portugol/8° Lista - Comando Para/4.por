programa
{
	inclua biblioteca Util
	
	funcao inicio()
	{
		inteiro sorteio, contador, valor

		sorteio = Util.sorteia(1, 10)

		para(contador = 1; contador <= 5; contador++){
			escreva("Adivinhe qual o valor: ")
			leia(valor)
			se (valor == sorteio){
			escreva("Acertou!")
			contador = contador + 5
			}
			senao{
				escreva("Tente novamente!\n")
			}
		}
		escreva("\nO valor sorteado era ", sorteio)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 273; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */