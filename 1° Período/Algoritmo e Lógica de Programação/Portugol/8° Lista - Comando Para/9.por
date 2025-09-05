programa
{
    funcao inicio()
    {
        inteiro i, j, N

        escreva("Digite o valor de N (1 a 9): ")
        leia(N)

        // Valida o valor de N
        se (N < 1 ou N > 9)
        {
            escreva("Valor inválido. Use um número entre 1 e 9.")
            retorne
        }

        // Loop para as linhas
        para (i = 1; i <= N; i++)
        {
            // Loop para imprimir o número i, i vezes
            para (j = 1; j <= i; j++)
            {
                escreva(i)
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
 * @POSICAO-CURSOR = 282; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */