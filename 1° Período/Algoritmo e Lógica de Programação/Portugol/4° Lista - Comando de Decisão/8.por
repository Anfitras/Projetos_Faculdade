programa
{
	
	funcao inicio()
	{
		real preco, taxa

		escreva("Qual o preço do produto?: R$ ")
		leia(preco)

		se (preco > 1500){
			taxa = preco + (5 * preco / 100)

			escreva("Seu produto foi taxado em 5%. O novo valor é de R$ ",taxa)
		}
		senao{
			escreva("Compra está dentro dos conformes!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 98; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */