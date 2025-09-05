#include <stdio.h>
int main()
{
    int v1, v2, v3, soma;

    printf("Escreva um valor: ");
    scanf("%d", &v1);
    printf("Escreva um valor: ");
    scanf("%d", &v2);
    printf("Escreva um valor: ");
    scanf("%d", &v3);

    soma = v1 + v2 + v3;

    printf("Soma dos digitos: %d", soma);

    return 0;
}