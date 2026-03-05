import java.util.Random;

public class App3 {
    public static void main(String[] args) {
        int[] numeros = new int[10];
        int maior = 0;
        int menor = 0;

        for (int i = 0; i < numeros.length; i++) {
            Random random = new Random();
            numeros[i] = random.nextInt(100) + 1;
            System.out.println(numeros[i]);

            if (i == 0)
                menor = numeros[i];

            if (maior < numeros[i])
                maior = numeros[i];

            if (menor > numeros[i])
                menor = numeros[i];
        }

        System.out.println("Maior Número: " + maior);
        System.out.println("Menor Número: " + menor);

    }
}
