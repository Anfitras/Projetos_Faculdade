#include <stdio.h>

int main()
{
    int votos1 = 0, votos2 = 0, votos3 = 0, voto;

    for (int i = 0; i < 15; i++)
    {
        printf("- Pedro (1)\n- Maria (2)\n- Joana (3)\nQual seu voto: ");
        scanf("%d", &voto);

        if (voto == 1)
            votos1++;
        else if (voto == 2)
            votos2++;
        else if (voto == 3)
            votos3++;
        else
        {
            printf("VOTO INVALIDO!\nVote Novamente: \n");
            i--;
            continue;
        }
    }

    if (votos1 == votos2 && votos2 == votos3)
        printf("Empate triplo! Todos com %d votos.\n", votos1);

    else if (votos1 == votos2 && votos1 > votos3)
        printf("Empate entre PEDRO e MARIA! Com %d votos cada.\n", votos1);
    else if (votos1 == votos3 && votos1 > votos2)
        printf("Empate entre PEDRO e JOANA! Com %d votos cada.\n", votos1);
    else if (votos2 == votos3 && votos2 > votos1)
        printf("Empate entre MARIA e JOANA! Com %d votos cada.\n", votos2);

    else if (votos1 > votos2 && votos1 > votos3)
        printf("Novo Presidente com %d votos: PEDRO\n", votos1);
    else if (votos2 > votos1 && votos2 > votos3)
        printf("Novo Presidente com %d votos: MARIA\n", votos2);
    else if (votos3 > votos1 && votos3 > votos2)
        printf("Novo Presidente com %d votos: JOANA\n", votos3);

    return 0;
}