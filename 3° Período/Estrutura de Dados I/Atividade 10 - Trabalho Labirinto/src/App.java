import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        char[][] meuLabirinto = new char[Labirinto.limit][Labirinto.limit];
        int posX, posY;

        Labirinto.criarLabirinto(meuLabirinto);
        Labirinto.mostrarLabirinto(meuLabirinto);

        System.out.println("\nPosições iniciais (linha e coluna):");
        Scanner scanner = new Scanner(System.in);
        posX = scanner.nextInt();
        posY = scanner.nextInt();

        Labirinto.percorrerLabirinto(meuLabirinto, posX, posY);

        scanner.close();
    }
}