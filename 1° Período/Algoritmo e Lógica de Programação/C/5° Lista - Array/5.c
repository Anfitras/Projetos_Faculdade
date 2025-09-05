#include <stdio.h>

int main()
{
    int vetor[10];
    int i, j;
    int repetido;

    printf("Digite 10 numeros inteiros:\n");
    for (i = 0; i < 10; i++)
    {
        printf("Posicao %d: ", i + 1);
        scanf("%d", &vetor[i]);
    }

    printf("\nValores repetidos:\n");
    int encontrou = 0;

    for (i = 0; i < 10; i++)
    {
        repetido = 0;
        for (j = i + 1; j < 10; j++)
        {
            if (vetor[i] == vetor[j])
            {
                repetido = 1;
                break;
            }
        }

        if (repetido)
        {
            int ja_mostrado = 0;
            for (j = 0; j < i; j++)
            {
                if (vetor[i] == vetor[j])
                {
                    ja_mostrado = 1;
                    break;
                }
            }
            if (!ja_mostrado)
            {
                printf("%d\n", vetor[i]);
                encontrou = 1;
            }
        }
    }

    if (!encontrou)
    {
        printf("Nenhum valor repetido encontrado.\n");
    }

    return 0;
}
