import java.util.Iterator;

public class PilhaEncadeada<T> implements Iterable<T> {
    private No<T> topo;
    private int size;

    public PilhaEncadeada() {
        this.topo = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        return this.topo == null;
    }

    public boolean push(T dado) {
        No<T> novoNo = new No<>(dado);
        novoNo.setProximo(this.topo);
        this.topo = novoNo;
        this.size++;
        return true;
    }

    public T pop() {
        if (!isEmpty()) {
            T removido = this.topo.getDado();
            this.topo = this.topo.getProximo();
            this.size--;
            return removido;
        }
        return null;
    }

    public T peek() {
        if (isEmpty()) {
            return null;
        }

        return this.topo.getDado();
    }

    @Override
    public String toString() {
        StringBuilder pilha = new StringBuilder("*** Topo ***\n");
        No<T> noAtual = this.topo;
        while (noAtual != null) {
            pilha.append(noAtual.getDado() + "\n");
            noAtual = noAtual.getProximo();
        }

        pilha.append("__________\n");
        return pilha.toString();
    }

    @Override
    public Iterator<T> iterator() {
        return new PilhaIterator();
    }

    private class PilhaIterator implements Iterator<T> {
        private No<T> atual = topo;

        public boolean hasNext() {
            return atual != null;
        }

        public T next() {
            T elementoRetorno = atual.getDado();
            atual = atual.getProximo();
            return elementoRetorno;
        }
    }

}