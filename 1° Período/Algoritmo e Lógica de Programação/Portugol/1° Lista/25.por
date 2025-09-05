programa
{
	
	funcao inicio()
	{
		cadeia nome
		real salfixo, salfinal, vendas, valorvendas
		
		escreva("Qual o seu nome comleto?: ")
		leia(nome)
		escreva("Qual o seu salário fixo?: ")
		leia(salfixo)
		escreva("Qual o valor total em vendas que você faturou esse mês?: ")
		leia(vendas)

		valorvendas = 15 * vendas / 100

		salfinal = salfixo + valorvendas

		escreva("Olá ",nome, ". Sendo seu salário fixo de R$ ",salfixo,". O seu salário final esse mês é R$ ",salfinal)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 386; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */