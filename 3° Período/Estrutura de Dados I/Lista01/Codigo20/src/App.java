public class App {
    public static void main(String[] args) throws Exception {
        FilaEncadeada fila = new FilaEncadeada();

        for (int i = 0; i < 10; i++) {
            fila.enqueue(i * 3);
        }

        System.out.println("Fila: " + fila.toString());

        System.out.println(fila.estaEmOrdemCrescente());

    }
}
