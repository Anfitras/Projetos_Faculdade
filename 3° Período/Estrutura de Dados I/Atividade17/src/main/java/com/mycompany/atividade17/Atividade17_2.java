package com.mycompany.atividade17;

import java.util.Scanner;

public class Atividade17_2 {

    public static int hash(long chave, int tamanho, int deslocamento) {
        return (int) ((chave + deslocamento) % tamanho);
    }

    public static void main(String[] args) {
        int tamanho = 10;
        long[] tabelaHash = new long[tamanho];
        int posicao;
        int deslocamento;

        while (true) {
            deslocamento = 0;
            Scanner leia = new Scanner(System.in);
            System.out.println("\nDigite o CPF: ");
            long cpf = leia.nextLong();

            System.out.println("CPF: " + cpf);
            posicao = hash(cpf, tamanho, deslocamento);
            System.out.println("Hash: " + posicao);

            if (tabelaHash[posicao] == 0) {
                tabelaHash[posicao] = cpf;
            } else {
                while (tabelaHash[posicao] != 0) {
                    System.out.println("Colisao - Deslocando...");
                    deslocamento++;
                    posicao = hash(cpf, tamanho, deslocamento);
                }
                tabelaHash[posicao] = cpf;
                
            }

            System.out.println("*** Mostrando a tabela ***");
            for (int i = 0; i < tamanho; i++) {
                System.out.print("|" + tabelaHash[i]);
            }
        }
    }
}
