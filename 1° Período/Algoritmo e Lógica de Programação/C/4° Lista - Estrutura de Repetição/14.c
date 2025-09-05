#include <stdio.h>

int main()
{
    int N, i;
    double soma = 0.0;

    printf("Digite o valor de N: ");
    scanf("%d", &N);

    for (i = 1; i <= N; i++)
    {
        soma += 1.0 / (2 * i);
    }

    printf("Soma da serie = %.6f\n", soma);

    return 0;
}
