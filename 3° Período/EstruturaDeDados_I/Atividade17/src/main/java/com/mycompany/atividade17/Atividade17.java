package com.mycompany.atividade17;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;

public class Atividade17 {

    public static void main(String[] args) {

        // Usando HashMap
        HashMap<Integer, String> pessoaHash = new HashMap<>();

        int qtdElementos = 100000;
        long tempoInicial = System.currentTimeMillis();

        for (int i = 0; i < qtdElementos; i++) {
            pessoaHash.put(i, "Pessoa " + i);
        }

        for (int i = 0; i < qtdElementos; i++) {
            pessoaHash.containsKey(i);
        }

        long tempoFinal = System.currentTimeMillis();
        double tempoTotalSeg = (tempoFinal - tempoInicial) / 1000.00;

        System.out.printf("Hash Time (s): %.3f\n", tempoTotalSeg);

        // Usando ArrayList
        ArrayList<String> pessoaList = new ArrayList<>();

        tempoInicial = System.currentTimeMillis();

        for (int i = 0; i < qtdElementos; i++) {
            pessoaList.add("Pessoa " + i);
        }

        for (int i = 0; i < qtdElementos; i++) {
            pessoaList.contains("Pessoa " + i);
        }

        tempoFinal = System.currentTimeMillis();
        tempoTotalSeg = (tempoFinal - tempoInicial) / 1000.00;

        System.out.printf("ArrayList Time (s): %.3f\n", tempoTotalSeg);

        // Usando LinkedList
        LinkedList<String> pessoaLinkedList = new LinkedList<>();

        tempoInicial = System.currentTimeMillis();

        for (int i = 0; i < qtdElementos; i++) {
            pessoaLinkedList.add("Pessoa " + i);
        }

        for (int i = 0; i < qtdElementos; i++) {
            pessoaLinkedList.contains("Pessoa " + i);
        }

        tempoFinal = System.currentTimeMillis();
        tempoTotalSeg = (tempoFinal - tempoInicial) / 1000.00;

        System.out.printf("ArrayList Time (s): %.3f\n", tempoTotalSeg);
    }
}
