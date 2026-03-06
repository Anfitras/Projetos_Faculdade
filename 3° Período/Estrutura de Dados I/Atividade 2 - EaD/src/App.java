import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== SISTEMA DE PILHA ===\n");
        System.out.print("Digite a capacidade da pilha: ");
        int capacidade = scanner.nextInt();

        Pilha<Integer> pilha = new Pilha<>(capacidade);
        int opcao;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Adicionar elemento (push)");
            System.out.println("2. Remover elemento (pop)");
            System.out.println("3. Ver topo (peek)");
            System.out.println("4. Verificar se está vazia (isEmpty)");
            System.out.println("5. Verificar se está cheia (isFull)");
            System.out.println("6. Visualizar pilha");
            System.out.println("7. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o valor a adicionar: ");
                    int valor = scanner.nextInt();
                    if (pilha.push(valor)) {
                        System.out.println("Elemento " + valor + " adicionado com sucesso!");
                    } else {
                        System.out.println("Erro: Pilha está cheia!");
                    }
                    break;

                case 2:
                    Integer removido = pilha.pop();
                    if (removido != null) {
                        System.out.println("Elemento removido: " + removido);
                    } else {
                        System.out.println("Erro: Pilha está vazia!");
                    }
                    break;

                case 3:
                    Integer topo = pilha.peek();
                    if (topo != null) {
                        System.out.println("Topo da pilha: " + topo);
                    } else {
                        System.out.println("Pilha está vazia!");
                    }
                    break;

                case 4:
                    if (pilha.isEmpty()) {
                        System.out.println("A pilha está vazia.");
                    } else {
                        System.out.println("A pilha NÃO está vazia.");
                    }
                    break;

                case 5:
                    if (pilha.isFull()) {
                        System.out.println("A pilha está cheia.");
                    } else {
                        System.out.println("A pilha NÃO está cheia.");
                    }
                    break;

                case 6:
                    System.out.println("\n" + pilha);
                    break;

                case 7:
                    System.out.println("Encerrando programa...");
                    break;

                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
        } while (opcao != 7);

        scanner.close();
    }
}
