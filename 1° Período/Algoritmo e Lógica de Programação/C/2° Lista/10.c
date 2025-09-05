#include <stdio.h>

int main()
{
    int qtd_banana, qtd_maca, qtd_laranja;
    double preco_banana, preco_maca, preco_laranja;
    double total;

    printf("Quantidade de bananas vendidas: ");
    scanf("%d", &qtd_banana);
    printf("Preco unitario da banana: R$");
    scanf("%lf", &preco_banana);

    printf("Quantidade de macas vendidas: ");
    scanf("%d", &qtd_maca);
    printf("Preco unitario da maca: R$");
    scanf("%lf", &preco_maca);

    printf("Quantidade de laranjas vendidas: ");
    scanf("%d", &qtd_laranja);
    printf("Preco unitario da laranja: R$");
    scanf("%lf", &preco_laranja);

    total = qtd_banana * preco_banana + qtd_maca * preco_maca + qtd_laranja * preco_laranja;

    printf("Total arrecadado no dia: R$%.2lf\n", total);

    return 0;
}
