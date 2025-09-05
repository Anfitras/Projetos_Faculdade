programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		inteiro contador, valor, soma

		valor = 0
		contador = 10
		soma = 0
		enquanto (contador > 0){
			escreva("Digite um valor: ")
			leia(valor)
			contador = contador - 1

			se (valor % 2 != 0){
				soma = soma + valor
			}
		}
		escreva("A soma dos números ímpares é de ",soma)
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