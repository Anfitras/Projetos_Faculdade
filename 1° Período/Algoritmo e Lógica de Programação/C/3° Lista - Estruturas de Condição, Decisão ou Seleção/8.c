#include <stdio.h>

int main()
{
	float horasTrabalhadas, salarioBruto, salarioLiquido;
	float valorHora = 19.50;
	float imposto = 0.10;

	printf("Digite o numero de horas trabalhadas: ");
	scanf("%f", &horasTrabalhadas);

	salarioBruto = horasTrabalhadas * valorHora;

	if (salarioBruto > 1500.0)
	{
		salarioLiquido = salarioBruto * (1 - imposto);
	}
	else
	{
		salarioLiquido = salarioBruto;
	}

	printf("Salario bruto: R$ %.2f\n", salarioBruto);
	printf("Salario liquido: R$ %.2f\n", salarioLiquido);

	return 0;
}
