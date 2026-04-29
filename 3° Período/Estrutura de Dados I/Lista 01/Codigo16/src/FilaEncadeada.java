import java.util.Iterator;

public class FilaEncadeada implements Iterable<Integer> {
    private No inicio;
    private No fim;
    private int qtd;

    public FilaEncadeada() {
        this.inicio = null;
        this.fim = null;
        this.qtd = 0;
    }

    public boolean isEmpty() {
        return this.inicio == null;
    }

    public boolean enqueue(int novoElemento) {
        No novoNo = new No(novoElemento);

        if (this.isEmpty()) {
            this.inicio = novoNo;
        } else {
            this.fim.setProximo(novoNo);
        }

        this.fim = novoNo;
        this.qtd++;

        return true;
    }

    public Integer dequeue() {
        if (!this.isEmpty()) {
            int removido = this.inicio.getDado();

            this.inicio = this.inicio.getProximo();
            this.qtd--;

            return removido;
        }
        return null;
    }

    public int posicaoQueElementoSeEncontraNaFila(int elemento) {
        int posicao = 1;

        for (Integer e : this) {
            if (elemento == e) {
                return posicao;
            }
            posicao++;
        }

        return -1;
    }

    @Override
    public String toString() {
        String resultado = "";
        No aux = this.inicio;

        while (aux != null) {
            resultado += aux.getDado() + " | ";
            aux = aux.getProximo();
        }

        return resultado;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            private No aux = FilaEncadeada.this.inicio;

            @Override
            public boolean hasNext() {
                return aux != null;
            }

            @Override
            public Integer next() {
                if (aux != null) {
                    int value = aux.getDado();
                    aux = aux.getProximo();
                    return value;
                }
                return null;
            }
        };
    }
}
