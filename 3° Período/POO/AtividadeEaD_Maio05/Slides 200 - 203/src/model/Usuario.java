package model;

public class Usuario {
    private String nome;
    private String email;
    private String telefone;
    private String tipo;

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        this.telefone = null;
        this.tipo = "COMUM";
    }

    public Usuario(String nome, String email, String telefone) {
        this.nome = nome;
        this.email = email;
        this.telefone = telefone;
        this.tipo = "COMUM";
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String tel) {
        this.telefone = tel;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}