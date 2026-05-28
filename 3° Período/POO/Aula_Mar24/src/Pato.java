public class Pato extends Animal implements Voador, Nadador {
    @Override
    public void emitirSom() {
        System.out.println("Quack!");
    }

    @Override
    public void voar() {
        System.out.println("Pato");
    }

    @Override
    public void nadar() {
        System.out.println("Pato");
    }
}
