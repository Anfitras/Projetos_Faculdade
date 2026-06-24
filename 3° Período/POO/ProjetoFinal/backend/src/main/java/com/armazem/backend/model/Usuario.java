package com.armazem.backend.model;

public class Usuario {

    private Long id;
    private String username;
    private String senha;
    private Perfil perfil;

    public Usuario() {
    }

    public Usuario(Long id, String username, String senha, Perfil perfil) {
        this.id = id;
        this.username = username;
        this.senha = senha;
        this.perfil = perfil;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Perfil getPerfil() {
        return perfil;
    }

    public void setPerfil(Perfil perfil) {
        this.perfil = perfil;
    }
}
