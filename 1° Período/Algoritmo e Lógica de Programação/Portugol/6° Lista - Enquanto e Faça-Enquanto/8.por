programa
{
	
	funcao inicio()
	{
		inteiro valor, contador, dentro, fora

		contador = 10
		valor = 0
		dentro = 0
		fora = 0

		enquanto (contador > 0){
			escreva("Digite um valor: ")
			leia(valor)

			se (valor >= 1 e valor <= 20){
				dentro = dentro + 1
			}
			senao{
				fora = fora + 1
			}
			
			contador = contador - 1
		}
		escreva(dentro, " valores estão entre [1,20], e ", fora, " estão fora desse intervalo.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 428; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */