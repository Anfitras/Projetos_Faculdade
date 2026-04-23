import java.util.Random;

public class Labirinto {
    public static final int limit = 10;

    public static void mostrarLabirinto(char[][] array) {
        for (int i = 0; i < limit; i++) {
            System.out.println();
            for (int j = 0; j < limit; j++) {
                System.out.print(" " + array[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static void criarLabirinto(char[][] Lab) {
        Random random = new Random();
        for (int i = 0; i < limit; i++) {
            for (int j = 0; j < limit; j++) {
                Lab[i][j] = random.nextInt(4) == 1 ? '|' : '.';
            }
        }

        for (int i = 0; i < limit; i++) {
            Lab[0][i] = '*';
            Lab[limit - 1][i] = '*';
            Lab[i][0] = '*';
            Lab[i][limit - 1] = '*';
        }

        int x = random.nextInt(limit - 2) + 1;
        int y = random.nextInt(limit - 2) + 1;
        Lab[x][y] = 'Q';
    }

    static void percorrerLabirinto(char[][] labirinto, int i, int j) {
        if (labirinto[i][j] == '|' || labirinto[i][j] == '*') {
            System.out.println("Não se pode começar na parede. Tente novamente!");
            return;
        }

        Pilha<Integer> pilhaI = new Pilha<>(limit * limit);
        Pilha<Integer> pilhaJ = new Pilha<>(limit * limit);

        pilhaI.push(i);
        pilhaJ.push(j);

        boolean achou = false;

        while (!pilhaI.isEmpty()) {
            int atualI = pilhaI.peek();
            int atualJ = pilhaJ.peek();

            if (labirinto[atualI][atualJ] == 'Q') {
                achou = true;
                break;
            }

            labirinto[atualI][atualJ] = 'v';

            if (atualJ + 1 < limit && (labirinto[atualI][atualJ + 1] == '.' || labirinto[atualI][atualJ + 1] == 'Q')) {
                pilhaI.push(atualI);
                pilhaJ.push(atualJ + 1);
            } else if (atualI + 1 < limit
                    && (labirinto[atualI + 1][atualJ] == '.' || labirinto[atualI + 1][atualJ] == 'Q')) {
                pilhaI.push(atualI + 1);
                pilhaJ.push(atualJ);
            } else if (atualJ - 1 >= 0
                    && (labirinto[atualI][atualJ - 1] == '.' || labirinto[atualI][atualJ - 1] == 'Q')) {
                pilhaI.push(atualI);
                pilhaJ.push(atualJ - 1);
            } else if (atualI - 1 >= 0
                    && (labirinto[atualI - 1][atualJ] == '.' || labirinto[atualI - 1][atualJ] == 'Q')) {
                pilhaI.push(atualI - 1);
                pilhaJ.push(atualJ);
            } else {
                labirinto[atualI][atualJ] = 'x';
                pilhaI.pop();
                pilhaJ.pop();
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            System.out.flush();
            mostrarLabirinto(labirinto);
        }

        if (achou) {
            System.out.println("Queijo encontrado na posicao " + pilhaI.peek() + "," + pilhaJ.peek() + "!");
        } else {
            System.out.println("Impossivel encontrar o queijo!");
        }
    }
}