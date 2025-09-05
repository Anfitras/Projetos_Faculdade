programa
{
	
	funcao inicio()
	{
		inteiro num1

		escreva("Escolha um número: ")
		leia(num1)

		se ( num1 % 2 == 0){
			se ( num1 > 0){
				escreva("É um número par e positivo!")
			}
			senao se (num1 < 0){
				escreva("É um número par e negativo!")
			}
		}
		senao se ( (num1 % 2 == 1) ou (num1 % 2 == -1)){
			se ( num1 > 0){
				escreva("É um número ímpar e posivito!")
			}
			senao se (num1 < 0){
				escreva("É um número ímpar e negativo!")
			}
		}
		se (num1 == 0){
			escreva("Seu número é 0!")
		}
	}
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 310; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */