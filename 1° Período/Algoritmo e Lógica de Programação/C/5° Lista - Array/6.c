#include <stdio.h>
int main()
{
    int valores[15];

    for (int i = 0; i < 15; i++)
    {
        printf("Digite o %d valor: ", i + 1);
        scanf("%d", &valores[i]);
    }

    printf("Valores digitados maiores que 5: \n");

    for (int i = 0; i < 15; i++)
    {
        if (valores[i] > 5)
        {
            printf("%d\n", valores[i]);
        }
    }
    return 0;
}