import java.util.Scanner;

public class Pg35 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- 1° Exercício --------------");
        System.out.print("Digite o número 1: ");
        int numero1 = scanner.nextInt();
        System.out.print("Digite o número 2: ");
        int numero2 = scanner.nextInt();

        int soma = numero1 + numero2;
        int subtracao = numero1 - numero2;
        int multiplicacao = numero1 * numero2;
        int divisao = 0;
        boolean divisaoValida = numero2 != 0;
        if (divisaoValida) {
            divisao = numero1 / numero2;
        }

        System.out.println("Número 1: " + numero1);
        System.out.println("Número 2: " + numero2);
        System.out.println("Soma: " + soma);
        System.out.println("Subtração: " + subtracao);
        System.out.println("Multiplicação: " + multiplicacao);
        if (divisaoValida)
            System.out.println("Divisão: " + divisao);
        else
            System.out.println("Divisão: não é possível dividir por zero.");

        System.out.println("-------------- 2° Exercício --------------");

        System.out.print("Digite o número do dividendo: ");
        int num3 = scanner.nextInt();

        int div3 = num3 / 3;
        System.out.println(num3 + " / 3: " + div3);

        System.out.println("-------------- 3° Exercício --------------");

        System.out.print("Digite a nota 1: ");
        double nota1 = scanner.nextDouble();
        System.out.print("Digite a nota 2: ");
        double nota2 = scanner.nextDouble();
        System.out.print("Digite a nota 3: ");
        double nota3 = scanner.nextDouble();

        double media = (nota1 + nota2 + nota3) / 3;

        if (media >= 7)
            System.out.println("Aprovado!");
        else if (media < 5)
            System.out.println("Reprovado!");
        else
            System.out.println("Recuperação!");

        System.out.println("-------------- 4° Exercício --------------");

        System.out.print("Digite o número 4: ");
        int num4 = scanner.nextInt();
        System.out.print("Digite o número 5: ");
        int num5 = scanner.nextInt();

        if (num5 > num4)
            System.out.print("Número 5 > Número 4");
        else if (num5 < num4)
            System.out.print("Número 5 < Número 4");
        else
            System.out.print("Número 5 = Número 4");

        scanner.close();
    }
}
