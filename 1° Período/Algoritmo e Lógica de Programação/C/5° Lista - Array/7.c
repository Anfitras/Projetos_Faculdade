#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int numeroSecreto[8], loteria[8], pontos = 0;

    srand(time(NULL));

    for (int i = 0; i < 8; i++)
    {

        numeroSecreto[i] = rand() % 10 + 1;
    }

    for (int i = 0; i < 8; i++)
    {
        printf("Digite os numeros da loteria: ");
        scanf("%d", &loteria[i]);

        if (loteria[i] < 1 || loteria[i] > 10)
        {
            printf("Numero invalido! Digite um numero entre 1 e 10.\n");
            i--;
            continue;
        }

        if (loteria[i] == numeroSecreto[i])
        {
            pontos++;
        }
    }

    printf("\nVoce fez %d pontos!\n", pontos);

    printf("\nOs numeros sortados foram: ");

    for (int i = 0; i < 8; i++)
    {
        printf("\n%d", numeroSecreto[i]);
    }

    return 0;
}