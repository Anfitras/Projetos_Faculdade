#include <stdio.h>
int main()
{
    float salarios[12], maior, menor, soma = 0;

    for (int i = 0; i < 12; i++)
    {
        printf("Digite o %d salario: R$", i + 1);
        scanf("%f", &salarios[i]);
        soma += salarios[i];

        if (i == 0)
        {
            maior = menor = salarios[i];
        }
        else
        {
            if (salarios[i] > maior)
                maior = salarios[i];
            if (salarios[i] < menor)
                menor = salarios[i];
        }
    }

    printf("Maior: R$%.2f | Menor: R$%.2f | Soma: R$%.2f\n", maior, menor, soma);

    return 0;
}