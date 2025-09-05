programa
{
	
	funcao inicio()
	{
		cadeia nome
		inteiro codcurso

		escreva("Qual o seu nome?: ")
		leia(nome)
		escreva("Qual o código do seu curso? 1, 2, 3 ou 4: ")
		leia(codcurso)

		escreva("\nAluno: ",nome)

		se (codcurso == 1){
			escreva("\nCurso: Sistema de Informação")
		}
		senao se (codcurso == 2){
			escreva("\nCurso: Agronomia")
		}
		senao se (codcurso == 3){
			escreva("\nCurso: Administração")
		}
		senao se (codcurso == 4){
			escreva("\nCurso: Nutrição")
		}
		senao{
			escreva("\nACurso: Inválido")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 513; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */