programa
{
	inclua biblioteca Texto
	funcao inicio()
	{
		real n1, n2, resp
		cadeia tipo

		escreva("Escolha um valor: ")
		leia(n1)
		escreva("Escolha outro valor: ")
		leia(n2)
		escreva("Operação (S-soma, R-subtração, M-multiplicação, D-divisão): ")
		leia(tipo)

		tipo = Texto.caixa_alta(tipo)

		se (tipo == "S"){
			resp = n1 + n2
		}
		senao se (tipo == "R"){
			resp = n1 - n2
		}
		senao se (tipo == "M"){
			resp = n1 * n2
		}
		senao se (tipo == "D"){
			resp = n1 / n2
		}
		senao {
			escreva("Operação Inválida!")
			retorne
		}

		escreva("Resultado: ", resp)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 544; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */