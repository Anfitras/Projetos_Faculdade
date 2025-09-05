#include <stdio.h>
#include <stdlib.h>

typedef struct
{
    float tempo;
    int nadador;
} NadadorTempo;

int comparar(const void *a, const void *b)
{
    NadadorTempo *na = (NadadorTempo *)a;
    NadadorTempo *nb = (NadadorTempo *)b;
    if (na->tempo < nb->tempo)
        return -1;
    else if (na->tempo > nb->tempo)
        return 1;
    else
        return 0;
}

int main()
{
    NadadorTempo nt[3];
    int i;
    for (i = 0; i < 3; i++)
    {
        printf("Tempo do %d nadador: ", i + 1);
        scanf("%f", &nt[i].tempo);
        nt[i].nadador = i + 1;
    }

    qsort(nt, 3, sizeof(NadadorTempo), comparar);

    printf("\nOuro - Nadador %d.\n", nt[0].nadador);
    printf("Prata - Nadador %d.\n", nt[1].nadador);
    printf("Bronze - Nadador %d.\n", nt[2].nadador);

    return 0;
}