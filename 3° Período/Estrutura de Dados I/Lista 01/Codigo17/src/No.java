public class No {
    private int dado;
    private No proximo;

    public No(int nDado) {
        this.dado = nDado;
        this.proximo = null;
    }

    public int getDado() {
        return this.dado;
    }

    public No getProximo() {
        return this.proximo;
    }

    public void setDado(int nDado) {
        this.dado = nDado;
    }

    public void setProximo(No nProximo) {
        this.proximo = nProximo;
    }

    @Override
    public String toString() {
        return String.valueOf(this.dado);
    }
}
