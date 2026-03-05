import java.util.Scanner;

public class Pg36 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("-------------- 1° Exercício --------------");

        System.out.print("Digite um valor inteiro: ");
        int numero = scanner.nextInt();

        if (numero % 2 == 0) {
            System.out.println("O número " + numero + " é par.");
        } else {
            System.out.println("O número " + numero + " é ímpar.");
        }

        System.out.println("-------------- 2° Exercício --------------");

        System.out.print("Digite o 1° valor inteiro: ");
        int valor1 = scanner.nextInt();

        System.out.print("Digite o 2° valor inteiro: ");
        int valor2 = scanner.nextInt();

        System.out.print("Digite o 3° valor inteiro: ");
        int valor3 = scanner.nextInt();

        int maior = valor1;
        if (valor2 > maior) {
            maior = valor2;
        }
        if (valor3 > maior) {
            maior = valor3;
        }

        System.out.println("O maior valor é: " + maior);

        System.out.println("-------------- 3° Exercício --------------");

        System.out.print("Digite um ano: ");
        int ano = scanner.nextInt();

        boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);

        if (bissexto) {
            System.out.println("O ano " + ano + " é bissexto.");
        } else {
            System.out.println("O ano " + ano + " não é bissexto.");
        }

        System.out.println("-------------- 4° Exercício --------------");

        System.out.print("Digite o 1° número: ");
        double num1 = scanner.nextDouble();

        System.out.print("Digite o 2° número: ");
        double num2 = scanner.nextDouble();

        System.out.print("Digite o operador (+, -, *, /): ");
        char operador = scanner.next().charAt(0);

        switch (operador) {
            case '+':
                System.out.println("Resultado: " + (num1 + num2));
                break;
            case '-':
                System.out.println("Resultado: " + (num1 - num2));
                break;
            case '*':
                System.out.println("Resultado: " + (num1 * num2));
                break;
            case '/':
                if (num2 != 0) {
                    System.out.println("Resultado: " + (num1 / num2));
                } else {
                    System.out.println("Erro: divisão por zero.");
                }
                break;
            default:
                System.out.println("Operador inválido.");
        }

        System.out.println("-------------- 5° Exercício --------------");

        String usuarioCorreto = "admin";
        String senhaCorreta = "1234";

        System.out.print("Digite o usuário: ");
        String usuarioDigitado = scanner.next();

        System.out.print("Digite a senha: ");
        String senhaDigitada = scanner.next();

        boolean usuarioValido = usuarioDigitado.equals(usuarioCorreto);
        boolean senhaValida = senhaDigitada.equals(senhaCorreta);

        if (usuarioValido && senhaValida) {
            System.out.println("Acesso Permitido");
        } else if (!usuarioValido && senhaValida) {
            System.out.println("Acesso negado usuário");
        } else if (usuarioValido && !senhaValida) {
            System.out.println("Acesso negado senha");
        } else {
            System.out.println("Acesso negado usuário e senha");
        }

        scanner.close();
    }
}
