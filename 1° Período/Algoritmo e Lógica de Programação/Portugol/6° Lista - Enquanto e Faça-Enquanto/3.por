programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real valor, raiz

		escreva("Digite um número (0 para sair): ")
		leia(valor)

		enquanto (valor > 0){
			raiz = mat.arredondar(mat.raiz(valor, 2),2)
			escreva("A raiz do seu número é ", raiz)

			escreva("\nDigite um número (0 para sair): ")
			leia(valor)
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 179; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */