#include <stdio.h>
int main()
{
    float kmPercorrido, litros, media;

    printf("Kilometros percorridos: ");
    scanf("%f", &kmPercorrido);
    printf("Combustivel consumido (em litros): ");
    scanf("%f", &litros);

    media = kmPercorrido / litros;

    printf("Seu carro consume em media %.1f litros por kilometro rodado.", media);

    return 0;
}