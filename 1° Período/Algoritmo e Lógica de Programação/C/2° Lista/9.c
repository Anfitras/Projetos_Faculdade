#include <stdio.h>

int main()
{
    double preco_litro, capacidade, custo_total;

    printf("Digite o preco do litro de combustivel: R$");
    scanf("%lf", &preco_litro);

    printf("Digite a capacidade do tanque em litros: ");
    scanf("%lf", &capacidade);

    custo_total = preco_litro * capacidade;

    printf("Custo total para encher o tanque: R$%.2lf\n", custo_total);

    return 0;
}
