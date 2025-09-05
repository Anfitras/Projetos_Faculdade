#include <stdio.h>
int main()
{
    float notas = 0.0;
    float soma = 0.0;
    float media;
    int contador = 0, aprovados = 0, reprovados = 0;

    while (notas != -1)
    {
        printf("Nota: ");
        scanf("%f", &notas);
        if (notas == -1)
            break;

        if (notas > 10 || notas < 0)
        {
            printf("Valor Invalido. Digite uma nota entre 0 e 10\n");
            continue;
        }

        if (notas >= 7.0)
            aprovados++;

        else if (notas < 4)
            reprovados++;

        contador++;

        soma = soma + notas;
    }

    media = soma / contador;

    printf("\nMedia geral da turma: %.1f\n%d alunos foram aprovados.\n%d alunos foram reprovados.", media, aprovados, reprovados);

    return 0;
}