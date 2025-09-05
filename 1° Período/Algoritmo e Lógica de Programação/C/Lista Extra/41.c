#include <stdio.h>
#include <stdlib.h>

int comparar(const void *a, const void *b)
{
    return (*(int *)a - *(int *)b);
}

int main()
{
    int A[15], B[15], U[30];
    int tamanhoU = 0;

    printf("----- Digite os valores A -----\n");
    for (int i = 0; i < 15; i++)
    {
        printf("Valor %d: ", i + 1);
        scanf("%d", &A[i]);
    }

    printf("----- Digite os valores B -----\n");
    for (int i = 0; i < 15; i++)
    {
        printf("Valor %d: ", i + 1);
        scanf("%d", &B[i]);
    }

    for (int i = 0; i < 15; i++)
    {
        int repetido = 0;
        for (int j = 0; j < tamanhoU; j++)
        {
            if (A[i] == U[j])
            {
                repetido = 1;
                break;
            }
        }
        if (!repetido)
        {
            U[tamanhoU++] = A[i];
        }
    }

    for (int i = 0; i < 15; i++)
    {
        int repetido = 0;
        for (int j = 0; j < tamanhoU; j++)
        {
            if (B[i] == U[j])
            {
                repetido = 1;
                break;
            }
        }
        if (!repetido)
        {
            U[tamanhoU++] = B[i];
        }
    }

    qsort(U, tamanhoU, sizeof(int), comparar);

    printf("Valores de U em ordem crescente:\n");
    for (int k = 0; k < tamanhoU; k++)
    {
        printf("%d ", U[k]);
    }
    printf("\n");

    return 0;
}