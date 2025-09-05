#include <stdio.h>
int main()
{
    float notas[10], soma, media;

    for (int i = 0; i < 10; i++)
    {
        printf("Nota %d: ", i + 1);
        scanf("%f", &notas[i]);

        soma += notas[i];
    }

    media = soma / 10.0;

    printf("A media das notas e %.2f.", media);

    return 0;
}