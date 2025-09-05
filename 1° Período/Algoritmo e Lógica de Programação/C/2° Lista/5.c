#include <stdio.h>

int main()
{
    int numero, centena, dezena, unidade, invertido;

    printf("Digite um numero inteiro positivo de tres digitos: ");
    scanf("%d", &numero);

    if (numero < 100 || numero > 999)
    {
        printf("O numero deve ter tres digitos.\n");
        return 1;
    }

    centena = numero / 100;
    dezena = (numero / 10) % 10;
    unidade = numero % 10;

    invertido = unidade * 100 + dezena * 10 + centena;

    printf("Numero invertido: %d\n", invertido);

    return 0;
}
