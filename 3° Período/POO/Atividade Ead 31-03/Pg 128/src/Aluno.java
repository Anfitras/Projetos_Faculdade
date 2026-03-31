public class Aluno {
    private String nome;
    private int idade;
    private Instrumento instrumento;

    public Aluno(String nome, int idade, Instrumento instrumento) {
        this.nome = nome;
        this.idade = idade;
        this.instrumento = instrumento;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Instrumento getInstrumento() {
        return instrumento;
    }

    @Override
    public String toString() {
        return "Aluno: " + nome + " | Idade: " + idade + " | Instrumento: " + instrumento;
    }
}