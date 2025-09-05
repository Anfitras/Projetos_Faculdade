#include <stdio.h>

int main()
{
    int i, num, somaImpares = 0;

    printf("Digite 10 numeros inteiros:\n");

    for (i = 0; i < 10; i++)
    {
        printf("Numero %d: ", i + 1);
        scanf("%d", &num);

        if (num % 2 != 0)
        {
            somaImpares += num;
        }
    }

    printf("Soma dos numeros impares: %d\n", somaImpares);

    return 0;
}
