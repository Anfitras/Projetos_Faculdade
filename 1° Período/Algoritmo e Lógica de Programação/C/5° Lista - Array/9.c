#include <stdio.h>
int main()
{
    int c;

    printf("Digite o tamanho do vetor: ");
    scanf("%d", &c);

    if (c < 3)
    {
        printf("Tamanho do vetor deve ser maior que zero.\n");
        return 1;
    }

    int valores[c];
    int crescente = 1, decrescente = 1;

    for (int i = 0; i < c; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);
    }

    for (int i = 1; i < c; i++)
    {
        if (valores[i] > valores[i - 1])
            decrescente = 0;
        else if (valores[i] < valores[i - 1])
            crescente = 0;
    }

    if (crescente)
        printf("O vetor e crescente.\n");
    else if (decrescente)
        printf("O vetor e decrescente.\n");
    else
        printf("O vetor esta fora de ordem.\n");

    return 0;
}