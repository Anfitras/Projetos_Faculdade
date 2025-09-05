#include <stdio.h>
int main()
{
    int dias = 0;
    float depositos = 0.0;
    float total = 0.0;
    float meta = 150.0;

    while (meta > total)
    {
        printf("Quantos reais foram depositados hoje: R$");
        scanf("%f", &depositos);

        if (depositos < 0)
        {
            printf("--- Deposito Invalido! ---\n");
            continue;
        }

        total = total + depositos;

        dias++;
    }

    printf("\nVoce demorou %d dias para juntar R$%.2f.", dias, total);

    return 0;
}