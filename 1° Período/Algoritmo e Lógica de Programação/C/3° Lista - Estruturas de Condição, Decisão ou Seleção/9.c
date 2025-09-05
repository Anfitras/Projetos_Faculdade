#include <stdio.h>

int main()
{
	float a, b, c;

	printf("Digite as tres medidas dos lados do triangulo:\n");
	scanf("%f %f %f", &a, &b, &c);

	if (a < b + c && b < a + c && c < a + b)
	{
		if (a == b && b == c)
		{
			printf("Triangulo equilatero.\n");
		}
		else if (a == b || b == c || a == c)
		{
			printf("Triangulo isoceles.\n");
		}
		else
		{
			printf("triangulo escaleno.\n");
		}
	}
	else
	{
		printf("As medidas nao formam um triangulo.\n");
	}

	return 0;
}
