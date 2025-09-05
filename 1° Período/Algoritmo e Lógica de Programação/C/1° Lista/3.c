#include <stdio.h>
int main()
{
    float horas, velMedia, distancia;

    printf("Quantas horas a viajem vai demorar?: ");
    scanf("%f", &horas);
    printf("Qual a velocidade media do veiculo?: ");
    scanf("%f", &velMedia);

    distancia = horas * velMedia;

    printf("Distancia total: %.1f Km", distancia);

    return 0;
}