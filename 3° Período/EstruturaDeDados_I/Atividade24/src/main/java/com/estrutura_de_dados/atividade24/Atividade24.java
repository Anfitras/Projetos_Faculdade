package com.estrutura_de_dados.atividade24;

import java.util.Scanner;

public class Atividade24 {

    public static void main(String[] args) {
        Scanner leia = new Scanner(System.in);
        Fibonacci fibo = new Fibonacci();
        System.out.print("Termo: ");
        int termo = leia.nextInt();
        int resultado = fibo.calcular(termo);
        System.out.printf("Termo %d = %d", termo, resultado);

    }
}
