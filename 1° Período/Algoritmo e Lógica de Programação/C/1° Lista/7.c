#include <stdio.h>
int main()
{
    float investido, taxa, meses, juros, total;

    printf("Capital Investido: ");
    scanf("%f", &investido);
    printf("Taxa: ");
    scanf("%f", &taxa);
    printf("Meses de Investimento: ");
    scanf("%f", &meses);

    juros = investido * taxa * meses;

    total = investido + juros;

    printf("\nJuros = R$%.2f.\nMontante Total = R$%.2f.", juros, total);

    return 0;
}