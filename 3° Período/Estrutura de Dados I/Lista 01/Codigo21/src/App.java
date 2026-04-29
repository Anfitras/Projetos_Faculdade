public class App {
    public static void main(String[] args) throws Exception {
        PilhaEncadeada<Integer> pilha = new PilhaEncadeada<>();

        for (int i = 1; i <= 5; i++) {
            pilha.push(i * 10);
        }

        System.out.println(pilha.toString());

        System.out.println(pilha.peek());

    }
}
