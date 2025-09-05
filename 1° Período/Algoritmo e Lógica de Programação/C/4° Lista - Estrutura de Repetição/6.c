#include <stdio.h>
#include <math.h>

int main()
{
    int i;
    double resultado;

    for (i = 0; i <= 15; i++)
    {
        resultado = pow(3, i);
        printf("3^%d = %.0f\n", i, resultado);
    }

    return 0;
}
