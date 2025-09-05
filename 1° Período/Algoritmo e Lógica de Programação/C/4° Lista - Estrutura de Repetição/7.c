#include <stdio.h>

int main()
{
    float nota, soma = 0, maiorNota = 0;
    int contador = 0;

    printf("Digite as notas do aluno (nota negativa encerra):\n");

    while (1)
    {
        scanf("%f", &nota);

        if (nota < 0)
        {
            break;
        }

        soma += nota;
        contador++;

        if (nota > maiorNota)
        {
            maiorNota = nota;
        }
    }

    if (contador > 0)
    {
        float media = soma / contador;
        printf("Media das notas: %.2f\n", media);
        printf("Maior nota: %.2f\n", maiorNota);
    }
    else
    {
        printf("Nenhuma nota valida foi inserida.\n");
    }

    return 0;
}
