package com.example.thami.firebaseapp;

/**
 * Created by thami on 15/02/2018.
 */

public class Usuario
{
    private String nome;
    private String sobrenome;
    private int indade;

    public Usuario()
    {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIndade() {
        return indade;
    }

    public void setIndade(int indade) {
        this.indade = indade;
    }
}
