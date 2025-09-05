#include <stdio.h>

int main()
{
    int voto;
    int votosC[4] = {0, 0, 0, 0};
    int votosNulos = 0;
    int votosBranco = 0;
    int totalEleitores = 80;

    printf("Digite o codigo do voto para cada eleitor (1-4 para candidatos, 5 nulo, 6 branco):\n");

    for (int i = 1; i <= totalEleitores; i++)
    {
        printf("Eleitor %d: ", i);
        scanf("%d", &voto);

        switch (voto)
        {
        case 1:
        case 2:
        case 3:
        case 4:
            votosC[voto - 1]++;
            break;
        case 5:
            votosNulos++;
            break;
        case 6:
            votosBranco++;
            break;
        default:
            printf("Codigo invalido! Este voto sera considerado nulo.\n");
            votosNulos++;
            break;
        }
    }

    printf("\nResultados da eleicao:\n");
    for (int i = 0; i < 4; i++)
    {
        printf("Candidato %d: %d votos\n", i + 1, votosC[i]);
    }
    printf("Votos nulos: %d\n", votosNulos);
    printf("Votos em branco: %d\n", votosBranco);

    return 0;
}
