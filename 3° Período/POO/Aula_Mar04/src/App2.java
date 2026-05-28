import java.util.Scanner;

public class App2 {
    public static void main(String[] args) {
        int[] numeros = new int[5];
        int soma = 0;

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < numeros.length; i++) {
            System.out.print("Digite o " + (i + 1) + "° numero: ");
            numeros[i] = scanner.nextInt();
            soma += numeros[i];
        }

        double media = (double) soma / numeros.length;

        System.out.println("Soma: " + soma);
        System.out.println("Media: " + media);

        scanner.close();
    }
}
