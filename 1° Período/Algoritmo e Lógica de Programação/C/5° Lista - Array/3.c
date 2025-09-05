#include <stdio.h>
int main()
{
    int valores[6], quantimpares = 0, somapares = 0;

    for (int i = 0; i < 6; i++)
    {
        printf("Digite o %d numero: ", i + 1);
        scanf("%d", &valores[i]);

        if (valores[i] % 2 == 0)
        {
            somapares += valores[i];
        }
        else
        {
            quantimpares++;
        }
    }

    printf("\nValores pares digitados: ");

    for (int i = 0; i < 6; i++)
    {
        if (valores[i] % 2 == 0)
        {
            printf("%d ", valores[i]);
        }
    }

    printf("\nSoma dos valores pares: %d", somapares);

    printf("\nValores impares digitados: ");

    for (int i = 0; i < 6; i++)
    {
        if (valores[i] % 2 != 0)
        {
            printf("%d ", valores[i]);
        }
    }

    printf("\nQuantidade de impares: %d", quantimpares);

    return 0;
}