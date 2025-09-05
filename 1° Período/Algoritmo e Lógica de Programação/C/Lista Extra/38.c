#include <stdio.h>
int main()
{
    char palavra[31];
    int vogais = 0;

    printf("Digite uma palavra: ");
    scanf("%30s", palavra);

    for (int i = 0; palavra[i] != '\0'; i++)
    {
        if (palavra[i] == 'a' || palavra[i] == 'A')
            vogais++;
        if (palavra[i] == 'e' || palavra[i] == 'E')
            vogais++;
        if (palavra[i] == 'i' || palavra[i] == 'I')
            vogais++;
        if (palavra[i] == 'o' || palavra[i] == 'O')
            vogais++;
        if (palavra[i] == 'u' || palavra[i] == 'U')
            vogais++;
    }

    printf("Voce digitou: %s\nEssa palavra possui %d vogais.", palavra, vogais);

    return 0;
}