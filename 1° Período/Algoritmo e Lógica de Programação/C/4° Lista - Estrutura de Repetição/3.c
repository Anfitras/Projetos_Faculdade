#include <stdio.h>

int main()
{
    int valor, soma = 0, contador = 0;
    float media;

    printf("Digite valores inteiros positivos (0 para encerrar):\n");

    while (1)
    {
        scanf("%d", &valor);

        if (valor == 0)
        {
            break;
        }

        if (valor > 0)
        {
            soma += valor;
            contador++;
        }
        else
        {
            printf("Valor invalido! Digite apenas inteiros positivos ou 0 para sair.\n");
        }
    }

    if (contador > 0)
    {
        media = (float)soma / contador;
        printf("Media dos valores: %.2f\n", media);
    }
    else
    {
        printf("Nenhum valor valido foi inserido.\n");
    }

    return 0;
}
