#include <stdio.h>
int main()
{
    float peso, altura, imc;

    printf("Altura (em metros): ");
    scanf("%f", &altura);
    printf("Peso (em quilos): ");
    scanf("%f", &peso);

    imc = peso / (altura * altura);

    printf("Indice de Massa Corporal = %.2f Kg/m.", imc);

    return 0;
}