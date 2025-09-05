#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    srand(time(NULL));
    int numero = (rand() % 100) + 1;
    int tentativa, quantidade = 0;

    while (1)
    {
        printf("Tente adivinhar um valor entre 1 e 100: ");
        scanf("%d", &tentativa);

        quantidade++;

        if (tentativa > numero)
            printf("Muito alto, tente um valor menor.");
        else if (tentativa < numero)
            printf("Muito baixo, tente um valor maior.");
        else
        {
            printf("Parabens, voce acertou! Bastou apenas %d tentativas.", quantidade);
            break;
        }
    }

    return 0;
}