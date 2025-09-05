#include <stdio.h>
int main()
{
    float notas[5], soma, media;

    for (int i = 0; i < 5; i++)
    {
        printf("Nota %d: ", i + 1);
        scanf("%f", &notas[i]);

        soma += notas[i];
    }

    media = soma / 5;

    printf("A media das notas e %.2f.\n", media);

    if (media >= 6)
        printf("APROVADO!");

    else
        printf("REPROVADO!");

    return 0;
}