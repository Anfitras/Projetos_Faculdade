programa
{
	
	funcao inicio()
	{
		inteiro compra, pagamento, troco, notas_100, notas_10, notas_1

		escreva("Valor da Compra: ")
		leia(compra)
		escreva("Valor do Pagamento: ")
		leia(pagamento)

		troco = pagamento - compra

		se ( compra > pagamento){
			escreva("Pagamento Negado!")
		}

		notas_100 = troco / 100
        	troco = troco % 100

        	notas_10 = troco / 10
        	troco = troco % 10
        	
        	notas_1 = troco

        	se (notas_100 > 0){
            escreva(notas_100, " nota(s) de R$100\n")
        	}
        	se (notas_10 > 0){
            escreva(notas_10, " nota(s) de R$10\n")
        	}
        	se (notas_1 > 0){
            escreva(notas_1, " nota(s) de R$1\n")
        	}
   
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 729; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */