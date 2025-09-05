programa
{
	
	funcao inicio()
	{
		inteiro valor, infor, contador

		contador = 5
		infor = 0

		enquanto (contador > 0){
			escreva("Digite um valor: ")
			leia(valor)

			se (valor < 0){
				infor = infor + 1
			}

			contador = contador - 1
		}
		escreva("Você informou ",infor, " valores negativos!")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 280; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */