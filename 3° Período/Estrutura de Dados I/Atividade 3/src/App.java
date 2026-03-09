import java.util.Scanner;
import java.time.LocalDate;

public class App {
    static Scanner leia = new Scanner(System.in);

    private static int menu() {
        System.out.println("\n--- Menu Pilha de Recordes ---");
        System.out.println("1. Inserir novo recorde");
        System.out.println("2. Remover recorde do topo");
        System.out.println("3. Consultar recorde atual");
        System.out.println("4. Listar todos os recordes");
        System.out.println("0. Sair");
        System.out.print("Escolha: ");
        return leia.nextInt();
    }

    public static void main(String[] args) {
        System.out.print("Digite o tamanho inicial da pilha: ");
        int tamanho = leia.nextInt();
        Pilha<Recorde> pilhaRecordes = new Pilha<>(tamanho);

        int opcao;
        do {
            opcao = menu();
            switch (opcao) {
                case 1:
                    System.out.print("Nome do atleta: ");
                    leia.nextLine();
                    String nome = leia.nextLine();
                    System.out.print("Tempo: ");
                    double tempo = leia.nextDouble();

                    Recorde novo = new Recorde(LocalDate.now(), tempo, nome);
                    Recorde atual = pilhaRecordes.peek();

                    if (atual == null || novo.getTempo() < atual.getTempo()) {
                        pilhaRecordes.push(novo);
                        System.out.println("Novo recorde registrado com sucesso!");
                    } else {
                        System.out.println("Atenção: O tempo digitado não supera o recorde atual.");
                    }
                    break;

                case 2:
                    Recorde removido = pilhaRecordes.pop();
                    if (removido != null) {
                        System.out.println("Recorde removido: " + removido);
                    } else {
                        System.out.println("A pilha já está vazia.");
                    }
                    break;

                case 3:
                    Recorde topo = pilhaRecordes.peek();
                    if (topo != null) {
                        System.out.println("Recorde no topo: " + topo);
                    } else {
                        System.out.println("Não há recordes registrados.");
                    }
                    break;

                case 4:
                    System.out.println(pilhaRecordes.toString());
                    break;

                case 0:
                    System.out.println("Saindo do sistema...");
                    break;

                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
        } while (opcao != 0);
    }
}