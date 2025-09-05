programa
{
	
	funcao inicio()
	{
		real altura, largura, area, tinta

		escreva("Qual a altura da parede em metros?: ")
		leia(altura)
		escreva("Qual a largura da parede em metros?: ")
		leia(largura)

		area = largura * altura

		tinta = area / 2

		escreva("A área da parede é de ", area, " m². E você precisará de ", tinta, " baldes de tinta para pinta-lá.")
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */