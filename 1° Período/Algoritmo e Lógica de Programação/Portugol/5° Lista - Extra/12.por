programa
{
	
	funcao inicio()
	{
		inteiro ano_nasci, ano_atual, idade

		escreva("Ano de Nascimento: ")
		leia(ano_nasci)

		ano_atual = 2025
		idade = ano_atual - ano_nasci

		escreva("Você tem ", idade, " anos.\n")

		se (idade >= 18){
			escreva("Você já tem idade para votar e para conseguir a CNH!")
		}
		senao se (idade >= 16){
			escreva("Você já tem idade para votar!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 384; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */