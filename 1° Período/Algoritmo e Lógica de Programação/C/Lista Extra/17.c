#include <stdio.h>
int main()
{
    int v1, v2;

    printf("Digite um valor: ");
    scanf("%d", &v1);
    printf("Digite outro valor: ");
    scanf("%d", &v2);

    if (v1 > v2)
        printf("O %d e maior que o %d", v1, v2);

    else if (v2 > v1)
        printf("O %d e maior que o %d", v2, v1);

    else
        printf("Ambos sao %d, ou seja, iguais.", v1);

    return 0;
}