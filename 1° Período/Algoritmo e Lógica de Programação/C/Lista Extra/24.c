#include <stdio.h>
int main()
{
    int valores[10];
    int pos = 0, neg = 0;

    for (int i = 0; i < 10; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);

        if (valores[i] > 0)
            pos++;

        else if (valores[i] < 0)
            neg++;
    }

    printf("Voce digitou %d valores positivos e %d valores negativos.", pos, neg);

    return 0;
}