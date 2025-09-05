#include <stdio.h>
int main()
{
    float capital, taxa, montante;
    int tempo;

    printf("Capital inicial investido: R$");
    scanf("%f", &capital);
    printf("Taxa de Juros Mensal: ");
    scanf("%f", &taxa);
    printf("Tempo (em meses): ");
    scanf("%d", &tempo);

    montante = capital + (capital * taxa * tempo);

    printf("O montante final arrecadado usando o juros simples foi de R$%.2f", montante);

    return 0;
}