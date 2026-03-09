package com.example.ProjetoGerenciadorDeTarefa.Model;

public class Usuario {

    private int id;
    private String nomeUsuario;
    private String senhaHash;

    public Usuario() {}

    public Usuario(String nomeUsuario, String senhaHash) {
        this.nomeUsuario = nomeUsuario;
        this.senhaHash = senhaHash;
    }

    // construtor usado no login
    public Usuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getSenhaHash() {
        return senhaHash;
    }

    public void setSenhaHash(String senhaHash) {
        this.senhaHash = senhaHash;
    }

    public String getNome() {
        return nomeUsuario;
    }
}