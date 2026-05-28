public class App {
    public static void main(String[] args) {
        Fila fila = new Fila(5);

        for (int i = 0; i < 5; i++) {
            fila.enqueue(i * 3);
        }

        fila.dequeue();
        fila.dequeue();

        System.out.println("Fila: " + fila.toString());

        System.out.println(fila.elementoExisteNaFila(3));
    }
}
