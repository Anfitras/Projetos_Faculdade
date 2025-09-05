#include <stdio.h>

int main()
{
	int numeros[6], soma = 0;

	printf("Digite 6 numeros:\n");
	for (int i = 0; i < 6; i++)
	{
		scanf("%d", &numeros[i]);
		if (numeros[i] > 0)
		{
			soma += numeros[i];
		}
	}

	printf("Soma dos numeros positivos: %d\n", soma);

	return 0;
}
