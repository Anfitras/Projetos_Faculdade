#include <stdio.h>
int main()
{
    int base, exp, mult = 1;

    printf("Digite a base: ");
    scanf("%d", &base);
    printf("Digite o expoente: ");
    scanf("%d", &exp);

    for (int i = exp; i > 0; i--)
    {
        mult = mult * base;
    }

    printf("%d^%d = %d", base, exp, mult);

    return 0;
}