public class Peixe extends Animal implements Nadador {
    @Override
    public void emitirSom() {
        System.out.println("Blub blub!");
    }

    @Override
    public void nadar() {
        System.out.println("Peixe");
    }
}
