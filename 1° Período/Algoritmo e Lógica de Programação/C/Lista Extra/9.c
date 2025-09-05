#include <stdio.h>
int main()
{

    int valor;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    if (valor > 10)
        printf("Valor maior que dez.");

    else if (valor < 10)
        printf("Valor menor que dez");

    else
        printf("Valor igual a dez");

    return 0;
}