public class Fila implements Iterable<Integer> {

    private int inicio;
    private int fim;
    private int qtd;
    private int[] elementos;

    public Fila(int tamanho) {
        this.inicio = 0;
        this.fim = -1;
        this.qtd = 0;
        this.elementos = new int[tamanho];
    }

    public boolean isFull() {
        return this.qtd == this.elementos.length;
    }

    public boolean isEmpty() {
        return this.qtd == 0;
    }

    public boolean enqueue(int elemento) {
        if (!isFull()) {
            if (this.fim == this.elementos.length - 1)
                this.fim = -1;
            this.qtd++;
            this.fim++;
            this.elementos[this.fim] = elemento;
            return true;
        }
        return false;
    }

    public int dequeue() {
        if (!isEmpty()) {
            int removido = this.elementos[this.inicio];
            if (this.inicio == this.elementos.length - 1)
                this.inicio = 0;
            
            this.inicio++;
            this.qtd--;
            return removido;
        }
        return -1;
    }

    public boolean elementoExisteNaFila(int elemento) {
        for (int e : this) {
            if (e == elemento) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        int i = this.inicio;
        for (int cont = 0; cont < this.qtd; cont++) {
            sb.append(this.elementos[i]).append(" | ");
            if (i == this.elementos.length - 1)
                i = 0;
            else
                i++;
        }
        return sb.toString();
    }

    @Override
    public java.util.Iterator<Integer> iterator() {
        return new java.util.Iterator<Integer>() {
            private int count = 0;
            private int i = inicio;

            @Override
            public boolean hasNext() {
                return count < qtd;
            }

            @Override
            public Integer next() {
                if (!hasNext())
                    throw new java.util.NoSuchElementException();
                Integer value = elementos[i];
                i = (i + 1) % elementos.length;
                count++;
                return value;
            }
        };
    }
}
