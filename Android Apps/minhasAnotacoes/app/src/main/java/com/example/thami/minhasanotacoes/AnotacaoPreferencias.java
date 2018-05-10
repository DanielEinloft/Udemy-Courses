package com.example.thami.minhasanotacoes;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by thami on 08/02/2018.
 */

public class AnotacaoPreferencias
{
    private Context context;
    private SharedPreferences preferences;
    private static final String ARQUIVO = "ARQUIVO_NOME";
    private SharedPreferences.Editor editor;
    private final String CHAVENOME = "nome";

    public AnotacaoPreferencias(Context c)
    {
        context = c;
        preferences = context.getSharedPreferences(ARQUIVO,0);
        editor = preferences.edit();

    }


    public void salvarAnotacao(String text)
    {
        editor.putString(CHAVENOME,text);
        editor.commit();
    }

    public String recuperarAnotacao()
    {

        return preferences.getString(CHAVENOME,"");
    }


}
