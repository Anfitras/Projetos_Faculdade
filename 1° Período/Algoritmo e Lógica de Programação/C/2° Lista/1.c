#include <stdio.h>
int main()
{
    int dias;
    float preco_por_dia = 30.0;
    float total;

    printf("Digite os dias trabalhados pelo encanador: ");
    scanf("%d", &dias);

    total = preco_por_dia * dias;
    total = total - (8 * total / 100);

    printf("Total a pagar: R$%.2f", total);

    return 0;
}