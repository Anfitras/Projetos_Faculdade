#include <stdio.h>
int main()
{
    int cigarros_por_dia, anos_fumando;
    int total_cigarros;
    int minutos_perdidos;
    int dias_perdidos;

    printf("Quantos cigarros voce fuma por dia? ");
    scanf("%d", &cigarros_por_dia);

    printf("Ha quantos anos voce fuma? ");
    scanf("%d", &anos_fumando);

    total_cigarros = cigarros_por_dia * 365 * anos_fumando;
    minutos_perdidos = total_cigarros * 10;
    dias_perdidos = minutos_perdidos / (60 * 24);

    printf("Voce perdera aproximadamente %d dias de vida.\n", dias_perdidos);

    return 0;
}