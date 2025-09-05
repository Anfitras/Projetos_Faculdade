#include <stdio.h>
int main()
{
    char palavra[41];
    int palindromo = 1;
    int tamanho = 0;

    printf("Digite uma palavra de ate 40 letras: ");
    scanf("%40s", palavra);

    for (int i = 0; palavra[i] != '\0'; i++)
    {
        tamanho = i + 1;
    }

    for (int i = 0; i < tamanho / 2; i++)
    {
        if (palavra[i] != palavra[tamanho - i - 1])
        {
            palindromo = 0;
            break;
        }
    }

    if (palindromo)
        printf("E um palindromo!");

    else
        printf("Nao e um palindromo!");

    return 0;
}