programa
{
	
	funcao inicio()
	{
		real preco, precototal
		cadeia formapag

		escreva("Preço do Item: R$ ")
		leia(preco)

		escreva("\nFormas de Pagamento:")
		escreva("\n0 - À vista (25% de desconto)")
		escreva("\n1 - Cheque 30 dias (20% de desconto)")
		escreva("\n2 - Cartão de crédito 2x (10% de desconto)")
		escreva("\n3 - Cartão de crédito 3x (5% de desconto)")
		escreva("\nOutro - Negociada com vendedor (sem desconto)")
		escreva("\n\nQual a forma de pagamento?: ")
		leia(formapag)

		se (formapag == "0"){
			precototal = preco - (25 * preco / 100)
		}
		senao se (formapag == "1"){
			precototal = preco - (20 * preco / 100)
		}
		senao se (formapag == "2"){
			precototal = preco - (10 * preco / 100)
		}
		senao se (formapag == "3"){
			precototal = preco - (5 * preco / 100)
		}
		senao{
			precototal = preco
		}
		escreva("\nO valor total é de R$ ",precototal)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 448; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */