#include <stdio.h>
#include <stdlib.h>
int comparar(const void *a, const void *b)
{
    return (*(int *)b - *(int *)a);
}
int main()
{
    int idades[3];
    int idade_monica;

    printf("Idade de Dona Monica: ");
    scanf("%d", &idade_monica);

    for (int i = 0; i < 2; i++)
    {
        printf("Idade do %d filho: ", i + 1);
        scanf("%d", &idades[i]);
    }

    idades[2] = idade_monica - (idades[0] + idades[1]);

    printf("\nO 3 filho tem %d anos.\n", idades[2]);

    qsort(idades, 3, sizeof(int), comparar);

    printf("\nO filho mais velho tem %d anos.", idades[0]);

    return 0;
}