#include <stdio.h>
int main()
{
    int valor, soma = 0;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    for (int i = 2; i <= valor; i += 2)
    {
        soma += i;
    }

    printf("A soma de todos os numeros pares existentes no intervalo de 1 ate %d = %d", valor, soma);

    return 0;
}