import java.util.ArrayList;
import java.util.Scanner;

public class App4 {
    public static void main(String[] args) {
        ArrayList<Integer> numeros = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Digite um numero (0 para parar): ");
            int numero = scanner.nextInt();

            if (numero == 0) {
                break;
            }

            numeros.add(numero);
        }

        int soma = 0;
        for (int numero : numeros) {
            soma += numero;
        }

        int quantidade = numeros.size();
        double media = quantidade > 0 ? (double) soma / quantidade : 0.0;

        System.out.println("Quantidade de numeros digitados: " + quantidade);
        System.out.println("Soma: " + soma);
        System.out.println("Media: " + media);

        scanner.close();
    }
}
