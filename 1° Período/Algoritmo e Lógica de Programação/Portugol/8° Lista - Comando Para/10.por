programa
{
    funcao inicio()
    {
        inteiro n, i, j, numero

        escreva("Digite o número de linhas do Triângulo de Floyd: ")
        leia(n)

        numero = 1

        // Loop para as linhas
        para (i = 1; i <= n; i++)
        {
            // Loop para imprimir i números na linha
            para (j = 1; j <= i; j++)
            {
                escreva(numero," ")
                numero = numero + 1
            }
            escreva("\n")
        }
    }
}

/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 390; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */