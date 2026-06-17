package com.mycompany.atividade22;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Atividade22 {

    private static ArrayList<String> gerarEmailsCampanhaA() {
        ArrayList<String> emails = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            emails.add("cliente_" + i + "@email.com");
        }
        return emails;
    }

    private static ArrayList<String> gerarEmailsCampanhaB() {
        ArrayList<String> emails = new ArrayList<>();
        for (int i = 70; i < 160; i++) {
            emails.add("cliente_" + i + "@email.com");
        }
        return emails;
    }

    public static void main(String[] args) {
        ArrayList<String> listaCampanhaA = gerarEmailsCampanhaA();
        List<String> listaCampanhaB = gerarEmailsCampanhaB();

        HashSet<String> hashSetCampanhaA = new HashSet<>(listaCampanhaA);
        HashSet<String> hashSetCampanhaB = new HashSet<>(listaCampanhaB);
        //Removendo clientes da campanha B que estão na campanha A /
        HashSet<String> clientesUnicosCampanhaA = new HashSet<>(hashSetCampanhaA);
        clientesUnicosCampanhaA.removeAll(hashSetCampanhaB);
        // Removendo clientes da campanha A que estão na campanha B
        HashSet<String> clientesUnicosCampanhaB = new HashSet<>(hashSetCampanhaB);
        clientesUnicosCampanhaB.removeAll(hashSetCampanhaA);

        HashSet<String> clientesDuplicados = new HashSet<>(hashSetCampanhaA);
        clientesDuplicados.retainAll(hashSetCampanhaB);

        System.out.println("\n=== CLIENTES ÚNICOS DE CADA CAMPANHA ===");
        System.out.println("Clientes únicos da Campanha A: " + clientesUnicosCampanhaA.size());
        for (String email : clientesUnicosCampanhaA) {
            System.out.println("Clientes únicos da Campanha A: " + email);
        }
        System.out.println("Clientes únicos da Campanha B: " + clientesUnicosCampanhaB.size());
        for (String email : clientesUnicosCampanhaB) {
            System.out.println("Clientes únicos da Campanha B: " + email);
        }
        System.out.println("Clientes duplicados da Campanha A e B: " + clientesDuplicados.size());
        for (String email : clientesDuplicados) {
            System.out.println("Clientes únicos da Campanha B: " + email);
        }
    }
}
