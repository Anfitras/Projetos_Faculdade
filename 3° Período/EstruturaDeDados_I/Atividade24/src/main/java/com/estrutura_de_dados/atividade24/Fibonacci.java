package com.estrutura_de_dados.atividade24;

public class Fibonacci {

    public int calcular(int n) {
        System.out.printf("fibo(%d)\n", n);
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return calcular(n - 1) + calcular(n - 2);
    }
}
