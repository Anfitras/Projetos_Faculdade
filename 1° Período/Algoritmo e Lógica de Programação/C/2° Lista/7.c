#include <stdio.h>

int main()
{
    double salario, energia, agua, roupa, comida, total_gastos, sobra;

    printf("Digite o valor do seu salario: R$");
    scanf("%lf", &salario);

    printf("Digite o gasto com energia: R$");
    scanf("%lf", &energia);

    printf("Digite o gasto com agua: R$");
    scanf("%lf", &agua);

    printf("Digite o gasto com roupa: R$");
    scanf("%lf", &roupa);

    printf("Digite o gasto com comida: R$");
    scanf("%lf", &comida);

    total_gastos = energia + agua + roupa + comida;
    sobra = salario - total_gastos;

    printf("Voce gasta mensalmente: R$%.2lf\n", total_gastos);
    printf("Depois de pagar as contas ainda sobram: R$%.2lf\n", sobra);

    return 0;
}
