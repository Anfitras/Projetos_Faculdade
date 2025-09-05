#include <stdio.h>
#include <stdlib.h>
#include <time.h>

int main()
{
    int numeros[6], jogos[6];
    int num_acertados = 0;
    srand(time(NULL));

    for (int i = 0; i < 6; i++)
    {
        numeros[i] = (rand() % 60) + 1;
        printf("%d ", numeros[i]);
    }

    for (int i = 0; i < 6; i++)
    {
        printf("Aposte o valor %d (entre 1 e 99): ", i + 1);
        scanf("%d", &jogos[i]);

        if (jogos[i] > 99 || jogos[i] < 1)
        {
            printf("Valor Invalido! Tente novamente.\n");
            i--;
            continue;
        }

        if (jogos[i] == numeros[i])
            num_acertados++;
    }

    printf("\n---- Numeros Sortados ----\n");

    for (int i = 0; i < 6; i++)
    {
        printf("%d ", numeros[i]);
    }

    printf("\n---- Numeros Jogados ----\n");

    for (int i = 0; i < 6; i++)
    {
        printf("%d ", jogos[i]);
    }

    if (num_acertados == 3)
        printf("\nPARABENS! Voce ganhou um terno.");
    else if (num_acertados == 4)
        printf("\nPARABENS! Voce ganhou uma quadra.");
    else if (num_acertados == 5)
        printf("\nPARABENS! Voce ganhou uma quina.");
    else if (num_acertados == 6)
        printf("\nPUTA QUE PARIU! VOCE ESTA COM O CU VIRADO PARA A LUA! Voce ganhou uma sena.");
    else
        printf("\nGanhou nada, seu pobre!");

    return 0;
}
