#include <stdio.h>
int main()
{
    float celsius, fahr;

    printf("Digite a temperatura em Celsius: ");
    scanf("%f", &celsius);

    fahr = celsius * 1.8 + 32;

    printf("%.1f Celsius em Fahrenheit = %.1f", celsius, fahr);

    return 0;
}