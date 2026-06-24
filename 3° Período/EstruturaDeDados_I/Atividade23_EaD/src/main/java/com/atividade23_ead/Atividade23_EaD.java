package com.atividade23_ead;

public class Atividade23_EaD {

    static int totalChamadas = 0;

    public static int fiboIterativo(int n) {
        int i, atual = 1, prox, ant = 0;
        for (i = 1; i <= n; i++) {
            System.out.println(atual);
            prox = atual + ant;
            ant = atual;
            atual = prox;
        }
        return ant;
    }

    public static int fiboR(int n) {
        System.out.println("-> fiboR(" + n + ")");
        totalChamadas++;
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }

        return fiboR(n - 1) + fiboR(n - 2);
    }

    public static void main(String[] args) {
        fiboR(7);
        System.out.println("Total de chamadas: " + totalChamadas);
    }
}
