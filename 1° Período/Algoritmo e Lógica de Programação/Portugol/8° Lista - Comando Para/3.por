programa
{
	
	funcao inicio()
	{
		inteiro nota, contador, maior, menor
		real media, soma

		soma = 0
		maior = 0
		menor = 10


		para (contador = 1; contador <= 10; contador++){
			escreva("Nota: ")
			leia(nota)

			soma = soma + nota

			se (nota > maior)
				maior = nota

			se (nota < menor)
				menor = nota
		}

		media = soma / 10

		escreva(soma, "\n", media, "\n", maior, "\n", menor)
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 409; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */