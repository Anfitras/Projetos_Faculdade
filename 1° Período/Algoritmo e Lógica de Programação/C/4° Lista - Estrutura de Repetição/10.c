#include <stdio.h>

int main()
{
    const float volume_total_ml = 20000.0;
    const float vazamento_ml = 50.0;
    const int intervalo_minutos = 30;

    int total_vazamentos = (int)(volume_total_ml / vazamento_ml);
    int tempo_total_minutos = total_vazamentos * intervalo_minutos;
    float tempo_total_horas = tempo_total_minutos / 60.0;

    printf("O garrafao estara vazio em aproximadamente %.2f horas.\n", tempo_total_horas);

    return 0;
}
