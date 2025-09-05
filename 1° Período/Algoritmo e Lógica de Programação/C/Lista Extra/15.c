#include <stdio.h>
int main()
{

    int v1, v2, soma;

    printf("Digite um valor: ");
    scanf("%d", &v1);
    printf("Digite outra valor para somar: ");
    scanf("%d", &v2);

    soma = v1 + v2;

    printf("A soma dos números e: %d", soma);

    return 0;
}