#include <stdio.h>

int main()
{
    int idade;

    printf("Digite a idade: ");
    scanf("%d", &idade);

    if (idade < 16)
    {
        printf("Classe eleitoral: Nao Eleitor.\n");
    }
    else if ((idade >= 18 && idade <= 65))
    {
        printf("Classe eleitoral: Eleitor obrigatorio.\n");
    }
    else
    {
        printf("Classe eleitoral: Eleitor facultativo.\n");
    }

    return 0;
}
