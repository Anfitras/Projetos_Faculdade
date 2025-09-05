#include <stdio.h>
int main()
{
    int latas, garrafa_600, garrafa_2l;
    float total_latas, total_garrafa_600, total_garrafa_2l, total;

    printf("Latas compradas: ");
    scanf("%d", &latas);
    printf("Garrafas de 600ml compradas: ");
    scanf("%d", &garrafa_600);
    printf("Garrafas de 2L compradas: ");
    scanf("%d", &garrafa_2l);

    total_latas = latas * 0.35;
    total_garrafa_600 = garrafa_600 * 0.6;
    total_garrafa_2l = garrafa_2l * 2;

    total = total_garrafa_2l + total_garrafa_600 + total_latas;

    printf("\nTotal de litros comprados: %.1f L.", total);

    return 0;
}