#include <stdio.h>

int main()
{
    int anoNascimento, idade;

    printf("Digite o ano de nascimento: ");
    scanf("%d", &anoNascimento);

    idade = 2025 - anoNascimento;

    if (idade >= 16)
    {
        printf("Com %d anos, pode votar na eleicao para prefeito.\n", idade);
    }
    else
    {
        printf("Com %d anos, NAO pode votar na eleicao para prefeito.\n", idade);
    }

    return 0;
}
