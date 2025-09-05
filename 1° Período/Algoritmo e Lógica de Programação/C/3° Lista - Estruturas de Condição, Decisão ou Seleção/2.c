#include <stdio.h>

int main()
{
    float distancia, tempo, velocidadeMedia;

    printf("Digite a distancia percorrida (em km): ");
    scanf("%f", &distancia);

    printf("Digite o tempo da viagem (em horas): ");
    scanf("%f", &tempo);

    if (tempo <= 0)
    {
        printf("Tempo invalido. Deve ser maior que zero.\n");
        return 1;
    }

    velocidadeMedia = distancia / tempo;

    printf("Velocidade media: %.2f km/h\n", velocidadeMedia);

    if (velocidadeMedia > 110)
    {
        printf("Velocidade acima do limite permitido (110 km/h).\n");
    }
    else
    {
        printf("Velocidade dentro do limite permitido.\n");
    }

    return 0;
}
