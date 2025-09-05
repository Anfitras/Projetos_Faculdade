#include <stdio.h>
int main()
{
    int valor, mult;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    for (int i = 1; i <= 10; i++)
    {
        mult = valor * i;

        printf("%d x %d = %d\n", valor, i, mult);
    }

    return 0;
}