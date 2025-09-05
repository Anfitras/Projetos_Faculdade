#include <stdio.h>
int main()
{
    int valores[25];
    int maior = 0, atual = 1;

    for (int i = 0; i < 25; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);
    }

    for (int i = 0; i < 24; i++)
    {
        if (valores[i] < valores[i + 1])
        {
            atual++;

            if (atual > maior)
                maior = atual;
        }

        else
            atual = 1;
    }

    printf("A maior subsequencia continua estritamente crescente tem %d valores.", maior);

    return 0;
}