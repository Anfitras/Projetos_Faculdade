#include <stdio.h>
int main()
{
    float valorTotal = 780000.0;
    float vencedor1 = 0.46;
    float vencedor2 = 0.32;
    float vencedor3 = 1 - (vencedor1 + vencedor2);

    vencedor1 = vencedor1 * valorTotal;
    vencedor2 = vencedor2 * valorTotal;
    vencedor3 = vencedor3 * valorTotal;

    printf("Vencedor 1 = R$%.2f.\nVencedor 2 = R$%.2f.\nVencedor 3 = R$%.2f\n.", vencedor1, vencedor2, vencedor3);

    return 0;
}