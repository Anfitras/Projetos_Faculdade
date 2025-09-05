#include <stdio.h>

int main()
{
    int colecao[100] = {0};
    int totalFigurinhas = 0;
    int dias = 0;
    int i, fig;

    while (totalFigurinhas < 100)
    {
        printf("Digite as 5 figurinhas do dia %d:\n", dias + 1);
        for (i = 0; i < 5; i++)
        {
            scanf("%d", &fig);
            if (fig < 1 || fig > 100)
            {
                printf("Figurinha inválida. Digite um número de 1 a 100.\n");
                i--;
                continue;
            }
            if (colecao[fig - 1] == 0)
            {
                colecao[fig - 1] = 1;
                totalFigurinhas++;
            }
        }
        dias++;
    }

    printf("Lucas completou o álbum em %d dias.\n", dias);
    return 0;
}
