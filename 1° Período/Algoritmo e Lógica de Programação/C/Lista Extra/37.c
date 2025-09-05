#include <stdio.h>
int main()
{
    int valor;
    float soma = 0.0;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    for (int n = 1; n <= valor; n++)
    {

        soma = soma + (1.0 / n);
    }

    printf("A serie armonica de 1 + 1/2 + ... + 1/%d = %.2f", valor, soma);

    return 0;
}