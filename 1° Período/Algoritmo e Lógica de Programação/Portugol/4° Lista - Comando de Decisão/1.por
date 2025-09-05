programa
{
	
	funcao inicio()
	{
		caracter cor

		escreva("Qual a cor do sinal? Verde ('V') | Amarelo ('A') | Vermelho ('P'): ")
		leia(cor)

		se (cor == 'v' ou cor == 'V'){
			escreva("Siga!")
		}
		senao se (cor == 'a' ou cor == 'A'){
			escreva("Atenção!")
		}
		senao se (cor == 'p' ou cor == 'P'){
			escreva("Pare!")
		}
		senao{
			escreva("Cor Inválida!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 370; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */