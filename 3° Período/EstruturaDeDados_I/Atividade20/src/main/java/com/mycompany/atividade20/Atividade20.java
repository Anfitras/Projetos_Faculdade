package com.mycompany.atividade20;

import java.time.LocalDate;
import java.util.Scanner;

public class Atividade20 {

    public static Cupom lerCupom() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Código do cupom: ");
        long codigo = sc.nextLong();
        System.out.print("Percentual de desconto: ");
        double desconto = sc.nextDouble();
        System.out.print("Data de validade (AAAA-MM-DD): ");
        LocalDate dataValidade = LocalDate.parse(sc.next());
        return new Cupom(
                codigo,
                desconto,
                dataValidade);
    }

    private static int menu(Scanner scanner) {
        System.out.println("\t\t*** IFSULDEMINAS - CAMPUS MACHADO ***");
        System.out.println("\t\t*** Estrutura de Dados I ***");
        System.out.println("\t\t*** HASH ENCADEADO - Separate Chaining ***");
        System.out.println("1-Inserir");
        System.out.println("2-Usar Cupom");
        System.out.println("0-Sair");
        System.out.print("Escolha uma opcao: ");
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomHashMap<Cupom> meuHashMap = new CustomHashMap<>();
        long chave;
        int op;
        do {
            System.out.println(meuHashMap.toString());
            System.out.println("Pressione Enter para continuar...");
            scanner.nextLine();
            op = menu(scanner);
            switch (op) {
                case 1:
                    Cupom cupom = lerCupom();
                    meuHashMap.put(cupom.getCodigo(), cupom);
                    System.out.println("Cupom inserido: " + cupom);
                    break;

                case 2:
                    System.out.print("Chave para busca: ");
                    chave = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer
                    Cupom cupom1 = meuHashMap.get(chave);
                    if (cupom1 == null) {
                        System.out.println("Cupom nao encontrado.");
                        break;
                    }

                    System.out.print("Valor da compra: R$");
                    double valorCompra = scanner.nextLong();
                    scanner.nextLine(); // Limpar o buffer

                    double valorDesconto = valorCompra * (cupom1.getDesconto() / 100);
                    double valorFinal = valorCompra - valorDesconto;

                    if (cupom1.getDataValidade().isBefore(LocalDate.now())) {
                        System.out.println("\nPara o cupom " + chave + ":" + cupom1.toString());
                        System.out.println("Cupom para uso: " + chave);
                        System.out.println("Desconto encontrado: R$" + String.format("%.2f", valorDesconto));

                        System.out.println("Cupom vencido!");
                    } else {
                        System.out.println("\nPara o cupom " + chave + ":" + cupom1.toString());
                        System.out.println("Cupom para uso: " + chave);
                        System.out.println("Desconto encontrado: R$" + String.format("%.2f", valorDesconto));
                        System.out.println("Cupom válido! - Valor da compra: R$" + String.format("%.2f", valorCompra));
                        System.out.println("Valor com desconto: R$" + String.format("%.2f", valorFinal));
                    }

                    meuHashMap.remove(chave);
                    System.out.println("Cupom removido!");

                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();

                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;

                default:
                    System.out.println("Opcao invalida.");
                    break;
            }

        } while (op != 0);

        scanner.close();
    }
}
