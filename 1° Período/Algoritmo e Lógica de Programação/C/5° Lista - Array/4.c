#include <stdio.h>
int main() {
    int cubo[10];

    for(int i = 1; i < 11; i++){
        cubo[i] = i * i;
    }

    for(int i = 1; i < 11; i++){
        printf("%d\n", cubo[i]);
    }

    return 0;
}