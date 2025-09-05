#include <stdio.h>

int main()
{
    int num, contador50 = 0;

    printf("Digite numeros inteiros (0 para encerrar):\n");

    while (1)
    {
        scanf("%d", &num);

        if (num == 0)
        {
            break;
        }

        if (num == 50)
        {
            contador50++;
        }
    }

    printf("O numero 50 foi informado %d vezes.\n", contador50);

    return 0;
}
