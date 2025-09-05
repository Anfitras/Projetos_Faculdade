#include <stdio.h>

int main()
{
    float salario, somaSalario = 0;
    int numFilhos, somaFilhos = 0;
    int totalPessoas = 0;
    char continuar;

    do
    {
        printf("Digite o salario do habitante: R$ ");
        scanf("%f", &salario);

        printf("Digite o numero de filhos: ");
        scanf("%d", &numFilhos);

        somaSalario += salario;
        somaFilhos += numFilhos;
        totalPessoas++;

        printf("Deseja continuar a pesquisa? (S/N): ");
        scanf(" %c", &continuar); // espaço antes do %c evita pegar o '\n' anterior

    } while (continuar == 'S' || continuar == 's');

    if (totalPessoas > 0)
    {
        float mediaSalario = somaSalario / totalPessoas;
        float mediaFilhos = (float)somaFilhos / totalPessoas;

        printf("\n--- Relatorio Final ---\n");
        printf("Numero de pessoas pesquisadas: %d\n", totalPessoas);
        printf("Media de salario: R$ %.2f\n", mediaSalario);
        printf("Media de numero de filhos: %.2f\n", mediaFilhos);
    }
    else
    {
        printf("Nenhum dado foi inserido.\n");
    }

    return 0;
}
