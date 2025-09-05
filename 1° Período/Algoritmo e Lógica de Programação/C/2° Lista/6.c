#include <stdio.h>

int main()
{
    int bits;
    double bytes;

    printf("Digite o valor em bits: ");
    scanf("%d", &bits);

    bytes = bits / 8.0;

    printf("O valor em bytes eh: %.2lf\n", bytes);

    return 0;
}
