programa
{
	inclua biblioteca Matematica --> mat
	
	funcao inicio()
	{
		real altura, peso_ideal
		caracter genero

		escreva("Homem (H) ou Mulher (M): ")
		leia(genero)
		escreva("Qual sua altura?: ")
		leia(altura)

		se (genero == 'h' ou genero == 'H'){
			peso_ideal = mat.arredondar((72.7 * altura) - 58,2)
		}
		senao se (genero == 'm' ou genero == 'M'){
			peso_ideal = mat.arredondar((62.1 * altura) - 44.7,2)
		}
		senao{
			escreva("Gênero Inválido!")
			retorne
		}
		escreva("Seu peso ideal é ",peso_ideal," Kg.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 526; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */