#include <stdio.h>
int main()
{
    int valor;

    printf("Digite um valor: ");
    scanf("%d", &valor);

    for (int i = valor; i >= 0; i--)
    {
        printf("%d\n", i);
    }

    return 0;
}