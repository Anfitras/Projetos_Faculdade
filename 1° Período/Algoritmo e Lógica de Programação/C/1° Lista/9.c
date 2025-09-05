#include <stdio.h>
int main()
{

    float raio, area;

    printf("Valor do raio: ");
    scanf("%f", &raio);

    area = 3.1416 * (raio * raio);

    printf("Area: %.2f m quadrados.", area);

    return 0;
}