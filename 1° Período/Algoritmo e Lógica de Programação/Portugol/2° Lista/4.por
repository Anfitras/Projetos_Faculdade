programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real preco, desconto

		escreva("Qual o preço do item?: R$ ")
		leia(preco)

		desconto = mat.arredondar(preco - (preco * 5 / 100),2)

		escreva("O valor desse item com 5% de desconto é de R$ ", desconto)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 136; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */