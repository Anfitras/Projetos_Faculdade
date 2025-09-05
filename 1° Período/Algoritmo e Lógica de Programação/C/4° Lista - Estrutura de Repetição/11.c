#include <stdio.h>

int main()
{
    int N, i;
    int numBoi, numMaisGordo, numMaisMagro;
    float peso, pesoMaisGordo = -1, pesoMaisMagro = 1e9;

    printf("Digite a quantidade de bois: ");
    scanf("%d", &N);

    for (i = 0; i < N; i++)
    {
        printf("Digite o número do boi %d: ", i + 1);
        scanf("%d", &numBoi);

        printf("Digite o peso do boi %d: ", i + 1);
        scanf("%f", &peso);

        if (peso > pesoMaisGordo)
        {
            pesoMaisGordo = peso;
            numMaisGordo = numBoi;
        }

        if (peso < pesoMaisMagro)
        {
            pesoMaisMagro = peso;
            numMaisMagro = numBoi;
        }
    }

    printf("\nBoi mais gordo: Numero %d, Peso %.2f\n", numMaisGordo, pesoMaisGordo);
    printf("Boi mais magro: Numero %d, Peso %.2f\n", numMaisMagro, pesoMaisMagro);

    return 0;
}
