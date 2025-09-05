#include <stdio.h>
#include <string.h>

int main()
{
    char binario[8];
    int decimal = 0;

    printf("Digite um numero binario: ");
    scanf("%s", binario);

    int tamanho = strlen(binario);
    for (int i = 0; i < tamanho; i++)
    {
        if (binario[i] == '1')
        {
            decimal += 1 << (tamanho - i - 1);
        }
    }

    printf("Decimal: %d\n", decimal);
    return 0;
}