#include <stdio.h>

int main()
{
	int usuario, senha;
	int usuarioCorreto = 999;
	int senhaCorreta = 123;

	printf("Digite o usuario (inteiro): ");
	scanf("%d", &usuario);

	printf("Digite a senha (inteiro): ");
	scanf("%d", &senha);

	if (usuario != usuarioCorreto && senha != senhaCorreta)
	{
		printf("Usuario e senha incorretos.\n");
	}
	else if (usuario != usuarioCorreto)
	{
		printf("Usuario incorreto.\n");
	}
	else if (senha != senhaCorreta)
	{
		printf("Senha incorreta.\n");
	}
	else
	{
		printf("Login efetuado com sucesso.\n");
	}

	return 0;
}
