#include <stdio.h>

int main()
{
    int K, count = 0, num;

    printf("Digite um numero inteiro K: ");
    scanf("%d", &K);

    if (K % 3 != 0)
    {
        K = K + (3 - (K % 3));
    }

    num = K;

    printf("Os 10 primeiros multiplos de 3 maiores ou iguais a K sao:\n");

    while (count < 10)
    {
        printf("%d ", num);
        num += 3;
        count++;
    }

    printf("\n");

    return 0;
}
