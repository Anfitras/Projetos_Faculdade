programa
{
	
	funcao inicio()
	{
		real preco, taxa
		inteiro ano

		escreva("Ano do Veículo: ")
		leia(ano)

		escreva("Preço do Veículo: R$ ")
		leia(preco)

		se (ano < 2000){
			taxa = 1 * preco / 100
		}
		senao{
			taxa = 1.5 * preco / 100
		}
		escreva("O carro por ano terá uma taxa de R$ ",taxa," de imposto.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 299; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */