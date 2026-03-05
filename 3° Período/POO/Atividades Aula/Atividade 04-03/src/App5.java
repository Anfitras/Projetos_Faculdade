import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class App5 {
    public static void main(String[] args) {
        Random random = new Random();
        int numeroSorteado = random.nextInt(100) + 1;

        ArrayList<Integer> tentativas = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Tente adivinhar o numero entre 1 e 100.");

        while (true) {
            System.out.print("Digite sua tentativa: ");
            int palpite = scanner.nextInt();
            tentativas.add(palpite);

            if (palpite == numeroSorteado) {
                System.out.println("Parabens! Voce acertou.");
                break;
            } else if (palpite < numeroSorteado) {
                System.out.println("O numero sorteado é maior.");
            } else {
                System.out.println("O numero sorteado é menor.");
            }
        }

        System.out.println("Quantidade de tentativas: " + tentativas.size());
        System.out.println("Tentativas feitas: " + tentativas);

        scanner.close();
    }
}
