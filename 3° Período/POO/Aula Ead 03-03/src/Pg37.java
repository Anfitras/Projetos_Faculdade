import java.util.Scanner;

public class Pg37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- 1° Exercício --------------");

        System.out.println("Contagem de 1 a 100 com for:");
        for (int i = 1; i <= 100; i++) {
            System.out.println(i);
        }

        System.out.println("Contagem de 1 a 100 com while:");
        int contador = 1;
        while (contador <= 100) {
            System.out.println(contador);
            contador++;
        }

        System.out.println("-------------- 2° Exercício --------------");

        System.out.print("Digite um número de 1 a 9: ");
        int numero = scanner.nextInt();

        if (numero >= 1 && numero <= 9) {
            System.out.println("Tabuada do " + numero + ":");
            for (int i = 1; i <= 10; i++) {
                System.out.println(numero + " x " + i + " = " + (numero * i));
            }
        } else {
            System.out.println("Valor inválido. Digite um número entre 1 e 9.");
        }

        System.out.println("-------------- 3° Exercício --------------");

        System.out.print("Digite o valor de N: ");
        int n = scanner.nextInt();

        if (n >= 1) {
            int soma = 0;
            for (int i = 1; i <= n; i++) {
                soma += i;
            }
            System.out.println("A soma de 1 até " + n + " é: " + soma);
        } else {
            System.out.println("Valor inválido. Digite um número maior ou igual a 1.");
        }

        System.out.println("-------------- 4° Exercício --------------");

        System.out.print("Digite um número inteiro para calcular o fatorial: ");
        int numeroFatorial = scanner.nextInt();

        if (numeroFatorial >= 0) {
            long fatorial = 1;
            for (int i = 1; i <= numeroFatorial; i++) {
                fatorial *= i;
            }
            System.out.println(numeroFatorial + "! = " + fatorial);
        } else {
            System.out.println("Valor inválido. O fatorial é definido para inteiros não negativos.");
        }

        System.out.println("-------------- 5° Exercício --------------");

        double nota;
        do {
            System.out.print("Digite uma nota entre 0 e 10: ");
            nota = scanner.nextDouble();

            if (nota < 0 || nota > 10) {
                System.out.println("Nota inválida. Tente novamente.");
            }
        } while (nota < 0 || nota > 10);

        System.out.println("Nota válida: " + nota);

        scanner.close();
    }
}
