#include <stdio.h>
int main()
{
    int valores[60], repeticoes[10];

    for (int i = 0; i < 10; i++)
    {
        repeticoes[i] = 0;
    }

    for (int i = 0; i < 60; i++)
    {
        printf("Digite um valor %d (entre 0 e 9): ", i + 1);
        scanf("%d", &valores[i]);

        if (valores[i] < 0 || valores[i] > 9)
        {
            printf("Valor invalido!\n");
            i--;
            continue;
        }

        else
        {
            repeticoes[valores[i]]++;
        }
    }

    printf("\n");

    for (int i = 0; i < 10; i++)
    {
        printf("Digito %d: %d ocorrencias\n", i, repeticoes[i]);
    }

    return 0;
}