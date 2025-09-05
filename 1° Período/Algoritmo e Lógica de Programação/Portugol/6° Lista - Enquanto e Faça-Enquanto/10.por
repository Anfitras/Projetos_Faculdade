programa
{
	
	funcao inicio()
	{
		inteiro soma, valor

		escreva("Digite um valor [230,520]: ")
		leia(valor)
		
		
		soma = 0
		enquanto (valor >= 230 e valor <= 520){
			
			se (valor % 2 == 0){
				soma = soma + valor
			}
			
			escreva("Digite um valor: ")
			leia(valor)
		
		}
		escreva("A soma dos valores é ", soma)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 97; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */