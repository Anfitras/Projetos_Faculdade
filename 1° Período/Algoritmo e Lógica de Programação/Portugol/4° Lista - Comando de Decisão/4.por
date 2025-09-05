programa
{
	
    funcao inicio()
    {
        cadeia cod_salgado, cod_bebida
        real qnt_salgado, qnt_bebida, prc_salgado, prc_bebida, prc_total

        escreva("101 = Coxinha   201 = Água\n")
        escreva("102 = Joelho    202 = Refrigerante\n")
        escreva("103 = Pizza     203 = Suco \n\n")

        escreva("Código do salgado: ")
        leia(cod_salgado)
        escreva("Quantidade de salgados: ")
        leia(qnt_salgado)

        escreva("Código da bebida: ")
        leia(cod_bebida)
        escreva("Quantidade de bebidas: ")
        leia(qnt_bebida)

        
        se (cod_salgado == "101"){
            prc_salgado = 4.50
        }
        senao se (cod_salgado == "102"){
            prc_salgado = 5.50
        }
        senao se (cod_salgado == "103"){
            prc_salgado = 6.00
        }
        senao{
            prc_salgado = 0
            escreva("Nenhum salgado escolhido!\n")
        }

     
        se (cod_bebida == "201"){
            prc_bebida = 3.00
        }
        senao se (cod_bebida == "202"){
            prc_bebida = 4.50
        }
        senao se (cod_bebida == "203"){
            prc_bebida = 5.50
        }
        senao{
            prc_bebida = 0
            escreva("Nenhuma bebida escolhida!\n")
        }

        prc_total = (prc_salgado * qnt_salgado) + (prc_bebida * qnt_bebida)

        se (prc_total > 100){
        	prc_total = prc_total - (10 * prc_total / 100)
        }

        escreva("\nPreço total a pagar: R$ ", prc_total)
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 1512; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */