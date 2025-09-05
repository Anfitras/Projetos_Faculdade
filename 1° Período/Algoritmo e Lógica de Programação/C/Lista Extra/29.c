#include <stdio.h>
int main()
{
    int valores[20];
    int maior, menor, posicaomaior = 0, posicaomenor = 0;

    for (int i = 0; i < 20; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);

        if (i == 0)
        {
            maior = menor = valores[i];
            posicaomaior = posicaomenor = 0;
        }
        else
        {
            if (valores[i] > maior)
            {
                maior = valores[i];
                posicaomaior = i;
            }
            if (valores[i] < menor)
            {
                menor = valores[i];
                posicaomenor = i;
            }
        }
    }

    printf("O maior valor foi o %d, na %d posicao.\nE o menor valor foi o %d, na %d posicao.", maior, posicaomaior, menor, posicaomenor);

    return 0;
}