#include <stdio.h>

int main()
{
    char letra;

    printf("Digite uma letra (maiuscula): ");
    scanf(" %c", &letra);

    if (letra == 'A' || letra == 'E' || letra == 'I' || letra == 'O' || letra == 'U')
    {
        printf("Vogal.\n");
    }
    else
    {
        printf("Nao Vogal.\n");
    }

    return 0;
}
