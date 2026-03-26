import java.util.Random;
import java.util.Scanner;

public class App1 {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(10) + 1;

        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite um numero de 1 a 10: ");
        int palpite = scanner.nextInt();

        if (palpite == numeroSorteado) {
            System.out.println("Voce acertou!");
        } else {
            System.out.println("Voce errou!");
        }

        System.out.println("Numero sorteado: " + numeroSorteado);

        scanner.close();
    }
}
