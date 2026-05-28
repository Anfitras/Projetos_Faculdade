import java.util.Random;
import java.util.Scanner;

public class Pg39 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double saldo = 1000.0;
        int opcao;

        do {
            System.out.println("-------------- 1° Exercício --------------");
            System.out.println("1 - Ver saldo");
            System.out.println("2 - Sacar");
            System.out.println("3 - Depositar");
            System.out.println("4 - Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Saldo atual: R$ " + saldo);
                    break;
                case 2:
                    System.out.print("Digite o valor para saque: R$ ");
                    double valorSaque = scanner.nextDouble();

                    if (valorSaque <= 0) {
                        System.out.println("Valor de saque inválido.");
                    } else if (valorSaque > saldo) {
                        System.out.println("Saque não permitido: saldo insuficiente.");
                    } else {
                        saldo -= valorSaque;
                        System.out.println("Saque realizado com sucesso.");
                        System.out.println("Saldo atual: R$ " + saldo);
                    }
                    break;
                case 3:
                    System.out.print("Digite o valor para depósito: R$ ");
                    double valorDeposito = scanner.nextDouble();

                    if (valorDeposito <= 0) {
                        System.out.println("Valor de depósito inválido.");
                    } else {
                        saldo += valorDeposito;
                        System.out.println("Depósito realizado com sucesso.");
                        System.out.println("Saldo atual: R$ " + saldo);
                    }
                    break;
                case 4:
                    System.out.println("Encerrando o sistema.");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }

            System.out.println();
        } while (opcao != 4);

        System.out.println("-------------- 2° Exercício --------------");

        Random random = new Random();
        int numeroAleatorio = random.nextInt(100) + 1;
        int tentativas = 0;
        int palpite;

        do {
            System.out.print("Tente adivinhar o número (1 a 100): ");
            palpite = scanner.nextInt();
            tentativas++;

            if (palpite < numeroAleatorio) {
                System.out.println("O número digitado é menor que o número aleatório.");
            } else if (palpite > numeroAleatorio) {
                System.out.println("O número digitado é maior que o número aleatório.");
            } else {
                System.out.println("Parabéns! Você acertou.");
            }
        } while (palpite != numeroAleatorio);

        System.out.println("Quantidade de tentativas: " + tentativas);

        scanner.close();
    }
}
