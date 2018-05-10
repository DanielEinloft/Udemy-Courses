package com.example.thami.organizze.config;

import com.google.firebase.auth.FirebaseAuth;

/**
 * Created by thami on 26/02/2018.
 */

public class ConfiguracaoFirebase
{
    //static pq quer acessar o sem precisar instanciar a classe. Dai pode acessar as informacoes da conta em qualquer
    //parte do codigo sem modificar as informações :) nao precisa ficar instanciando várias vezes
    private static FirebaseAuth autenticacao;

    //retorna instancia do firebaseauth
    public static FirebaseAuth getFirebaseAutenticacao()
    {
        if(autenticacao == null)
            autenticacao = FirebaseAuth.getInstance();

        return autenticacao;
    }



}
