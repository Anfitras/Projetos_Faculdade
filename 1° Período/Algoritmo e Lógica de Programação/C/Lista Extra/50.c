#include <stdio.h>
int main()
{
    int bino = 2018;
    int cino;

    printf("Chute um valor: ");
    scanf("%d", &cino);

    while (bino != cino)
    {
        printf("Chute outro valor: ");
        scanf("%d", &cino);
    }

    printf("Parabens, voce acertou, era %d.", bino);

    return 0;
}