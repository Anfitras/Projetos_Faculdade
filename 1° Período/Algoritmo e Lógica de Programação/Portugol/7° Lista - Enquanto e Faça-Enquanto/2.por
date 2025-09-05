programa
{
	
	funcao inicio()
	{
		inteiro idade, dividendo, idades, media

		escreva("Digite uma idade (0 para encerrar): ")
		leia(idade)

		dividendo = 0
		idades = 0

		enquanto (idade != 0){
			
			idades = idades + idade
			
			escreva("Digite uma idade (0 para encerrar): ")
			leia(idade)

			dividendo = dividendo + 1
		}
		
		media = idades / dividendo

		escreva("A media de idade é ", media)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 408; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */