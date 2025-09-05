#include <stdio.h>

int main()
{
    int valores[5], maior, menor, posicaomaior = 0, posicaomenor = 0;

    for (int i = 0; i < 5; i++)
    {
        printf("Digite o %d valor: ", i + 1);
        scanf("%d", &valores[i]);
    }

    maior = valores[0];
    menor = valores[0];

    for (int i = 0; i < 5; i++)
    {
        if (valores[i] > maior)
        {
            maior = valores[i];
            posicaomaior = i;
        }
        else if (valores[i] < menor)
        {
            menor = valores[i];
            posicaomenor = i;
        }
    }

    printf("Maior valor = %d na posição %d\n", maior, posicaomaior);
    printf("Menor valor = %d na posição %d\n", menor, posicaomenor);

    return 0;
}