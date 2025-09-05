#include <stdio.h>
#include <math.h>

int main()
{
    double a, b, hipotenusa;

    printf("Digite o valor do cateto a: ");
    scanf("%lf", &a);

    printf("Digite o valor do cateto b: ");
    scanf("%lf", &b);

    hipotenusa = sqrt(a * a + b * b);

    printf("Valor da hipotenusa: %.2lf\n", hipotenusa);

    return 0;
}
