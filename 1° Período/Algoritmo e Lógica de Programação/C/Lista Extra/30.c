#include <stdio.h>
int main()
{
    int nota;

    printf("Nota {1,100}: ");
    scanf("%d", &nota);

    if (nota >= 90)
        printf("Nota A");

    else if (nota >= 80)
        printf("Nota B");

    else if (nota >= 70)
        printf("Nota C");

    else if (nota >= 60)
        printf("Nota D");

    else
        printf("Nota F");

    return 0;
}