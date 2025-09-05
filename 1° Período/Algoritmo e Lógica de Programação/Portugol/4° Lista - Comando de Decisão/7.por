programa
{
	funcao inicio()
	{
		caracter cargo
		real salario, ajuste, dif, percentual

		escreva("Qual o seu salário?: ")
		leia(salario)

		escreva("\n(G) - Gerente\n(E) - Engenheiro\n(T) - Técnico\n(O) - Outro\n")
		escreva("\nQual o seu cargo?: ")
		leia(cargo)

		se (cargo == 'g' ou cargo == 'G') {
			percentual = 10
		}
		senao se (cargo == 'e' ou cargo == 'E') {
			percentual = 20
		}
		senao se (cargo == 't' ou cargo == 'T') {
			percentual = 30
		}
		senao se (cargo == 'o' ou cargo == 'O') {
			percentual = 40
		}
		senao {
			escreva("\nCargo não reconhecido!")
			retorne
		}

		ajuste = salario + (percentual * salario / 100)
		dif = ajuste - salario

		escreva("\nSeu salário era R$ ", salario, " Seu novo salário é R$ ", ajuste, ", e a diferença entre eles é de R$ ", dif)
	}
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 716; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */