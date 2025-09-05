#include <stdio.h>
int main()
{
    int valor = 1;
    int maior = 0;

    while (valor != 0)
    {
        printf("Escolha um valor (0 encerra): ");
        scanf("%d", &valor);

        if (valor > maior)
            maior = valor;
    }

    printf("O maior valor digitado foi: %d", maior);

    return 0;
}