public class App {
    public static void main(String[] args) throws Exception {
        PilhaEncadeada<Double> pilha = new PilhaEncadeada<>();

        pilha.push(10.5);
        pilha.push(20.75);
        pilha.push(30.0);

        System.out.println(pilha.toString());

    }
}
