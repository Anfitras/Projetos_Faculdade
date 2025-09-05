#include <stdio.h>
int main()
{
    int valor;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    if (valor % 2 == 0)
        printf("E um numero par!");

    else
        printf("E um numero impar!");

    return 0;
}