#include <stdio.h>
int main()
{
    int valores[3];
    int crescente = 1, decrescente = 1, fora_de_ordem = 0;

    for (int i = 0; i < 3; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);

        if (i > 0)
        {
            if (valores[i] > valores[i - 1])
                decrescente = 0;
            else if (valores[i] < valores[i - 1])
                crescente = 0;

            if (crescente == 0 && decrescente == 0)
                fora_de_ordem = 1;
        }
    }

    if (crescente)
        printf("Ordem crescente");

    else if (decrescente)
        printf("Ordem decrescente");

    else if (fora_de_ordem)
        printf("Fora de ordem");
    return 0;
}