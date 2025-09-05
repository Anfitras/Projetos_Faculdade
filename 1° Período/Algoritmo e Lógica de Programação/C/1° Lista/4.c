#include <stdio.h>
int main()
{
    float pTotal, pDesconto, desconto, porcentagem;

    printf("Valor do Produto: ");
    scanf("%f", &pTotal);
    printf("Porcentagem do desconto: ");
    scanf("%f", &porcentagem);

    desconto = porcentagem * pTotal / 100;

    pDesconto = pTotal - desconto;

    printf("Com %.1f%% de deconto, o produto perde R$%.2f. Custando ao todo R$%.2f.", porcentagem, desconto, pDesconto);

    return 0;
}