#include <stdio.h>

int main()
{
    int i;

    printf("Os 20 primeiros numeros pares sao:\n");

    for (i = 1; i <= 20; i++)
    {
        printf("%d ", i * 2);
    }

    printf("\n");
    return 0;
}
