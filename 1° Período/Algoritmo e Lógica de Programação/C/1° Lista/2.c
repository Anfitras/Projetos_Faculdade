#include <stdio.h>

int main()
{
    float valor;

    printf("Digite um valor: ");
    scanf("%f", &valor);

    float quadrado = valor * valor;

    printf("O quadrado do valor %.2f: %.2f\n", valor, quadrado);

    return 0;
}