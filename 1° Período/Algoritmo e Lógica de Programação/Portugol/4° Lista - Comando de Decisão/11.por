programa
{
	
	funcao inicio()
	{
		inteiro hora, nivel
		real salario

		escreva("Quantas aulas você deu esse mês?: ")
		leia(hora)
		escreva("Qual o seu nível de professor? 1, 2 ou 3?: ")
		leia(nivel)

		se (nivel == 1){
			salario = (12 * hora)
		}
		senao se (nivel == 2){
			salario = (17 * hora)
		}
		senao se (nivel == 3){
			salario = (25 * hora)
		}
		senao{
			escreva("\nNível informado está incorreto!")
			retorne
		}
		escreva("\nSeu salário esse mês é de R$ ", salario)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 314; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */