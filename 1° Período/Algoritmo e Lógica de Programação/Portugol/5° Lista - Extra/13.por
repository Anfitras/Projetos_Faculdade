programa
{
	
	funcao inicio()
	{
		real sal_bruto, sal_liquido, porcent

		escreva("Salário Bruto: ")
		leia(sal_bruto)

		se (sal_bruto < 2000){
			porcent = 10
		}
		senao{
			porcent = 20
		}

		sal_liquido = sal_bruto - (porcent * sal_bruto / 100)

		escreva("Salário Líquido = R$ ", sal_liquido)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 305; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */