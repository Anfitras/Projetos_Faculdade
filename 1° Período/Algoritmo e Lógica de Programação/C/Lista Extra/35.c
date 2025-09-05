#include <stdio.h>

int main()
{
    int votos = 0, cand_A = 0, cand_B = 0, nulo = 0, total = 0;

    while (1)
    {
        printf("\nCandidato A (1)\nCandidato B (2)\nNulo (0)\nEncerrar (-1)\nVote: ");
        scanf("%d", &votos);

        if (votos == -1)
        {
            break;
        }
        else if (votos == 1)
        {
            cand_A++;
            total++;
        }
        else if (votos == 2)
        {
            cand_B++;
            total++;
        }
        else if (votos == 0)
        {
            nulo++;
            total++;
        }
        else
        {
            printf("\nVOTO INVALIDO! Vote Novamente.\n");
        }
    }

    printf("\nVotacao encerrada!\n");
    printf("Candidato A: %d votos.\nCandidato B: %d votos.\nNulo: %d votos.\nTotal: %d votos.\n", cand_A, cand_B, nulo, total);

    return 0;
}