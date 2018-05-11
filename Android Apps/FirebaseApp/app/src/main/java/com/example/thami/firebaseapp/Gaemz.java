package com.example.thami.firebaseapp;

/**
 * Created by thami on 15/02/2018.
 */

public class Gaemz
{
    private String plataforma;
    private String caracteristica;
    private int nivel;

    public Gaemz() {
    }

    public String getPlataforma() {
        return plataforma;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
}
