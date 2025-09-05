#include <stdio.h>

int main()
{
    int numeros[40];
    int i, j;

    for (i = 0; i < 40; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &numeros[i]);
    }

    printf("\nValores que aparecem mais de uma vez:\n");

    for (i = 0; i < 40; i++)
    {
        int repetido = 0;

        for (j = 0; j < i; j++)
        {
            if (numeros[i] == numeros[j])
            {
                repetido = 1;
                break;
            }
        }

        if (repetido)
            continue;

        int cont = 0;
        for (j = 0; j < 40; j++)
        {
            if (numeros[i] == numeros[j])
            {
                cont++;
            }
        }

        if (cont > 1)
        {
            printf("Valor %d apareceu %d vezes.\n", numeros[i], cont);
        }
    }

    return 0;
}
