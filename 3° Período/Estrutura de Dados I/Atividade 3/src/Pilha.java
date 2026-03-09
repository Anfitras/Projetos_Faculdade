import java.util.Arrays;

public class Pilha<T> {
    private int topo;
    private T[] elementos;

    @SuppressWarnings("unchecked")
    public Pilha(int capacidade) {
        this.topo = -1;
        this.elementos = (T[]) new Object[capacidade];
    }

    public boolean isFull() {
        return this.topo == this.elementos.length - 1;
    }

    public boolean isEmpty() {
        return this.topo == -1;
    }

    private void resize() {
        int novaCapacidade = this.elementos.length * 2;
        this.elementos = Arrays.copyOf(this.elementos, novaCapacidade);
    }

    public void push(T elemento) {
        if (this.isFull()) {
            resize();
        }
        this.topo++;
        this.elementos[topo] = elemento;
    }

    public T pop() {
        if (!isEmpty()) {
            T removido = this.elementos[this.topo];
            this.elementos[this.topo] = null;
            this.topo--;
            return removido;
        }
        return null;
    }

    public T peek() {
        if (!isEmpty()) {
            return this.elementos[this.topo];
        }
        return null;
    }

    @Override
    public String toString() {
        if (isEmpty())
            return "Pilha vazia.";
        StringBuilder sb = new StringBuilder("--- Lista de Recordes ---\n");
        for (int i = this.topo; i >= 0; i--) {
            sb.append(this.elementos[i]).append("\n");
        }
        sb.append("-------------------------");
        return sb.toString();
    }
}