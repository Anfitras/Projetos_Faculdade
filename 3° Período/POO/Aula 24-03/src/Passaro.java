public class Passaro extends Animal implements Voador {
    @Override
    public void emitirSom() {
        System.out.println("Piu piu!");
    }

    @Override
    public void voar() {
        System.out.println("Pássaro");
    }
}
