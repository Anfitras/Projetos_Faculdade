public abstract class Instrumento {
    private String marca;
    private String tipo;

    protected Instrumento(String marca, String tipo) {
        this.marca = marca;
        this.tipo = tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getTipo() {
        return tipo;
    }

    @Override
    public String toString() {
        return tipo + " - Marca: " + marca;
    }
}