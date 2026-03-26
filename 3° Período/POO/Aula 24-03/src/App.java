public class App {
    public static void main(String[] args) throws Exception {
        Animal pato = new Pato();
        Animal peixe = new Peixe();
        Animal passaro = new Passaro();
        Animal cachorro = new Cachorro();

        Animal[] animais = { pato, peixe, passaro, cachorro };

        System.out.println("=== Todos os Sons ===");
        for (int i = 0; i < animais.length; i++) {
            Animal animal = animais[i];
            animal.emitirSom();
        }

        System.out.println("\n=== Voadores ===");
        for (int i = 0; i < animais.length; i++) {
            Animal animal = animais[i];
            if (animal instanceof Voador) {
                ((Voador) animal).voar();
            }
        }

        System.out.println("\n=== Nadadores ===");
        for (int i = 0; i < animais.length; i++) {
            Animal animal = animais[i];
            if (animal instanceof Nadador) {
                ((Nadador) animal).nadar();
            }
        }
    }
}
