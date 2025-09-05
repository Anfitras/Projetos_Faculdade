#include <stdio.h>
#include <math.h>

int main()
{
    float acesso_diario;
    float meta = 1000000.0;
    float dias_necessarios;

    printf("Acesso diario ao site: ");
    scanf("%f", &acesso_diario);

    dias_necessarios = ceil(meta / acesso_diario);

    printf("Com %.0f acessos simultaneos. Ira demorar %.0f dias para atingir a meta.", acesso_diario, dias_necessarios);

    return 0;
}