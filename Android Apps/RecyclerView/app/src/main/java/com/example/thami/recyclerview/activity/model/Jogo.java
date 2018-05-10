package com.example.thami.recyclerview.activity.model;

/**
 * Created by thami on 01/02/2018.
 */

public class Jogo
{
    private String games;
    private String gamesGeneros;
    private String gamesAnos;

    public Jogo(String tituloJogo,String genero, String ano)
    {
        games = tituloJogo;
        gamesGeneros = genero;
        gamesAnos = ano;

    }
    public Jogo() {}



    public String getGames() {
        return games;
    }

    public void setGames(String games) {
        this.games = games;
    }

    public String getGamesGeneros() {
        return gamesGeneros;
    }

    public void setGamesGeneros(String gamesGeneros) {
        this.gamesGeneros = gamesGeneros;
    }

    public String getGamesAnos() {
        return gamesAnos;
    }

    public void setGamesAnos(String gamesAnos) {
        this.gamesAnos = gamesAnos;
    }
}
