#include <stdio.h>
int main()
{
    int valor;
    int fatorial = 1;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    for (int i = valor; i > 0; i--)
    {
        fatorial *= i;
    }

    printf("O fatorial de %d: %d", valor, fatorial);

    return 0;
}