import java.util.Scanner;

public class Pg38 {
    public static void main(String[] args) {
        System.out.println("-------------- 1° Exercício --------------");
        System.out.println("Números pares de 1 a 100:");

        for (int i = 1; i <= 100; i++) {
            if (i % 2 != 0) {
                continue;
            }
            System.out.println(i);
        }

        System.out.println("-------------- 2° Exercício --------------");

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um número (negativo para encerrar): ");
            int numero = scanner.nextInt();

            if (numero < 0) {
                System.out.println("Número negativo digitado. Encerrando...");
                break;
            }

            System.out.println("Você digitou: " + numero);
        }

        System.out.println("-------------- 3° Exercício --------------");

        int quantidadePositivos = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "° número: ");
            int valor = scanner.nextInt();

            if (valor > 0) {
                quantidadePositivos++;
            }
        }

        System.out.println("Quantidade de números positivos: " + quantidadePositivos);

        System.out.println("-------------- 4° Exercício --------------");

        int quantidadePositivosEx4 = 0;
        for (int i = 1; i <= 10; i++) {
            System.out.print("Digite o " + i + "° número: ");
            int valor = scanner.nextInt();

            if (valor > 0) {
                quantidadePositivosEx4++;
            }
        }

        System.out.println("Quantidade de números positivos: " + quantidadePositivosEx4);

        System.out.println("-------------- 5° Exercício --------------");

        System.out.print("Digite um número inteiro: ");
        int numeroPrimo = scanner.nextInt();

        boolean ehPrimo = numeroPrimo > 1;
        for (int i = 2; i * i <= numeroPrimo && ehPrimo; i++) {
            if (numeroPrimo % i == 0) {
                ehPrimo = false;
            }
        }

        if (ehPrimo) {
            System.out.println(numeroPrimo + " é primo.");
        } else {
            System.out.println(numeroPrimo + " não é primo.");
        }

        scanner.close();
    }
}
