#include <stdio.h>
int main()
{
    int valor, contador = 0;

    printf("Digite um valor inteiro e positivo: ");
    scanf("%d", &valor);

    if (valor < 1)
    {
        printf("Erro! Por favor digite um valor positivo!");
        return 0;
    }

    for (int i = valor; i > 0; i--)
    {
        if (valor % i == 0)
            contador++;
    }

    printf("O numero %d tem %d divisores.\n", valor, contador);

    for (int i = valor; i > 0; i--)
    {
        if (valor % i == 0)
            printf("%d e um divisor de %d.\n", i, valor);
    }

    return 0;
}