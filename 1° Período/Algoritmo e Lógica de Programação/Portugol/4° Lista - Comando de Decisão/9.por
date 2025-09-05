programa
{
	
	funcao inicio()
	{
		real saque, dispo

		escreva("Quanto você dejesa sacar?: R$ ")
		leia(saque)

		dispo = 1000

		se (saque <= dispo){
			escreva("A quantidade informada é menor que a quantidade disponivel. Tudo certo!")
		}
		senao{
			escreva("A quantidade informada é maior que a quantidade disponivel. Tente outro valor!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 148; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */