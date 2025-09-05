#include <stdio.h>
int main()
{
    int valores[10], pares = 0, i;

    for (i = 0; i < 10; i++)
    {
        printf("Digite o %d valor: ", i + 1);
        scanf("%d", &valores[i]);

        if (valores[i] % 2 == 0)
        {
            pares += 1;
        }
    }

    printf("\nVetor lido: ");
    for (i = 0; i < 10; i++)
    {
        printf("%d ", valores[i]);
    }

    printf("\nQuantidade de valores pares: %d\n", pares);

    return 0;
}