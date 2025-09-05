programa
{
	
	funcao inicio()
	{
		inteiro idade

		escreva("Qual a idade do atleta?: ")
		leia(idade)

		se (idade <= 10){
			escreva("Categoria Infantil")
		}
		senao se (idade <= 17){
			escreva("Categoria  Juvenil")
		}
		senao{
			escreva("Categoria Sênior")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 268; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */