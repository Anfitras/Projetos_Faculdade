#include <stdio.h>
int main()
{
    int n;
    int a = 0, b = 1, c;

    printf("Digite um valor entre 1 e 30: ");
    scanf("%d", &n);

    while (n < 1 || n > 30)
    {
        printf("Digite um valor entre 1 e 30: ");
        scanf("%d", &n);
    }

    printf("%d\n", a);
    if (n > 1)
        printf("%d\n", b);

    for (int i = 2; i < n; i++)
    {
        c = a + b;
        printf("%d\n", c);
        a = b;
        b = c;
    }

    return 0;
}