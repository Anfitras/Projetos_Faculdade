#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int numeroSecreto, tentativa;

    srand(time(NULL));
    numeroSecreto = rand() % 1000 + 1;

    printf("Tente adivinhar o numero entre 1 e 1000!\n");

    do
    {
        printf("Digite sua tentativa: ");
        scanf("%d", &tentativa);

        if (tentativa < numeroSecreto)
        {
            printf("Muito baixo! Tente um numero maior.\n");
        }
        else if (tentativa > numeroSecreto)
        {
            printf("Muito alto! Tente um numero menor.\n");
        }
        else
        {
            printf("Parabens! Você acertou o numero: %d\n", numeroSecreto);
        }

    } while (tentativa != numeroSecreto);

    return 0;
}
