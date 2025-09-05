#include <stdio.h>
int main()
{
    int valores[15];
    int escolha;

    for (int i = 0; i < 15; i++)
    {
        printf("Digite o valor %d: ", i + 1);
        scanf("%d", &valores[i]);
    }

    printf("Digite agora um outro valor: ");
    scanf("%d", &escolha);

    for (int i = 0; i < 15; i++)
    {
        if (valores[i] == escolha)
            printf("O valor escolhido apareceu na %d posicao da sequencia.", i + 1);
    }

    return 0;
}