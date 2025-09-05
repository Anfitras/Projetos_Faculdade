#include <stdio.h>
int main()
{
    int valores[10];

    for (int i = 0; i < 10; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);
    }

    printf("\n---- Pares ----\n");

    for (int i = 0; i < 10; i++)
    {
        if (valores[i] % 2 == 0)
        {
            printf("%d ", valores[i]);
        }
    }

    printf("\n---- Impares ----\n");

    for (int i = 0; i < 10; i++)
    {
        if (valores[i] % 2 != 0)
        {
            printf("%d ", valores[i]);
        }
    }

    return 0;
}