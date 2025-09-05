#include <stdio.h>

int main()
{
    int ano;

    printf("Digite um ano: ");
    scanf("%d", &ano);

    if ((ano % 400 == 0) || ((ano % 4 == 0) && (ano % 100 != 0)))
    {
        printf("Ano Bissexto.");
    }
    else
    {
        printf("Nao Ano Bissexto");
    }

    return 0;
}
