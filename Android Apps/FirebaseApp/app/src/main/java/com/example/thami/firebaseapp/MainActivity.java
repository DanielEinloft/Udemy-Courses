package com.example.thami.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;


//IMPORTANTE: ALI EM CIMA EM EXECUCAO, TIRAR O FIREBASE E COLOCAR 'APP'!!!!!!!!
//O banco de dados no firebase criado para este projeto é o "projetoteste"
public class MainActivity extends AppCompatActivity
{
    //permite salvar dados do firebase. esse getreference aponta pra raiz
    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();
    private FirebaseAuth autenticacao =  FirebaseAuth.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        DatabaseReference usuarios  = referencia.child("usuarioss");
        DatabaseReference games  = referencia.child("mensagens").child("vydia gaemz");

/*
        //////////////////////////// CRIAR E SALVAR DADOS:
        //novo nodo folha. Pode ser usado para salvar ou atualizar. Caso nao exista o valor, ele cria
        referencia.child("pontos").setValue("100");
        referencia.child("usuarios2").child("001").child("nome").setValue("Danii");







        //usuarios.child("002").setValue("Outro user");


        Usuario user = new Usuario();
        user.setNome("mamae");
        user.setIndade(150);
        user.setSobrenome("querida");

        usuarios.child("003").setValue(user);


        Gaemz gamez = new Gaemz();

        gamez.setPlataforma("Switch");
        gamez.setCaracteristica("Oh yeah baby");
        games.setValue(gamez);
*/

        //RECUPERAR DADOS.

        //QUALQUER mudança dentro do usuário, esse objeto vai ser atuaalizado
/*
       games.addValueEventListener(new ValueEventListener()
        {
            //dado alterado no firebase
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                //data snapshop é o retorno do firebase.
                Log.i("firebase",dataSnapshot.getValue().toString());


            }


            //tratar erro na hora da requisição cancelada.
            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });
*/


       ////////////////////////////CADASTRO DE USUARIO

/*
        //cria user. Usa addoncompletelistener pra lidar com erros. Toda vez que cria, o user ja esta autenticado.
        autenticacao.createUserWithEmailAndPassword("danieleinloft93@gmail.com","123456789").addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                    Log.i("CreateUser","Sucesso ao cadastrar user");
                else
                    Log.i("CreateUser","Erro ao cadastrar user");
            }
        });
*/


        //////////////////////////VERIFICA SE TA LOGADO. Depois que o app criou o usuario (por ex, executou o codigo acima e e depois comentou, o usuario esta logado.
/*

        ////////////////////////////LOGAR USUARIO
        autenticacao.signInWithEmailAndPassword("danieleinloft93@gmail.com","123456789").addOnCompleteListener(new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                    Log.i("CurrentUser","Sucesso ao logar user");
                else
                    Log.i("CurrentUser","Erro ao logar user");
            }
        });

        ////////////////////////////DESLOGAR USUARIO
        //autenticacao.signOut(); //hardcore.

        //pega o user atual do app
        if( autenticacao.getCurrentUser() != null)
            Log.i("CreateUser","User logado");
        else
            Log.i("CreateUser","User não logado");
*/

    /////////////////////////Gerar identificador unico de forma automatica :)  (tipo user 001, 002, etc)


        DatabaseReference gamesS  = referencia.child("mensagens").child("novo").child("vydia gaemz");

        //usar metodo push
/*
        Gaemz gamez1 = new Gaemz();
        gamez1.setPlataforma("GAEMZ1");
        gamez1.setCaracteristica("dESCRICAO1");
        gamez1.setNivel(1);

        Gaemz gamez2 = new Gaemz();
        gamez2.setPlataforma("GAEMZ1");
        gamez2.setCaracteristica("dESCRICAO1");
        gamez2.setNivel(5);


        Gaemz gamez3 = new Gaemz();
        gamez3.setPlataforma("GAEMZ1");
        gamez3.setCaracteristica("dESCRICAO1");
        gamez3.setNivel(10);

        //gera o identificador unico
        gamesS.push().setValue(gamez1);
        gamesS.push().setValue(gamez2);
        gamesS.push().setValue(gamez3);
*/

        ////////////////////////FILTROS

        //usando o identificador.
        //DatabaseReference userPesquisa = gamesS.child("-L5MWsSfm29oI8N-tfzU");

        //usando queries

        //ordena os dados baseado pelo filho. Melhor usar o indice, é mais rapido
        //Query userPesquisa = gamesS.orderByChild("plataforma").equalTo("Switch");

        //limitar a lista :) Coloca os 2 primeiros itens
        //Query userPesquisa = gamesS.orderByKey().limitToFirst(2);



        //filtros de maior ou igual.. Apenas usuarios com nivel maior ou igual a 5
        //Query userPesquisa = gamesS.orderByChild("nivel").startAt(5);

        //menor ou igual
        //Query userPesquisa = gamesS.orderByChild("nivel").endAt(5);


        //entre 2 valores
        //Query userPesquisa = gamesS.orderByChild("nivel").endAt(5).startAt(4);


        //filtrar palavras. Só palavras que tenham J, no caso.... o +" \ uf8ff"  é recomendaçaõ da google, senao nao funfa
        //Query userPesquisa = gamesS.orderByChild("nivel").endAt("S"+"\uf8ff").startAt("S"+"\uf8ff");

        //criar ouvinte
        userPesquisa.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot)
            {
                //Gaemz g = dataSnapshot.getValue(Gaemz.class); //retorna um objeto gaemz :)
                //Log.i("dados users",  g.getPlataforma().toString());
                Log.i("dados users", dataSnapshot.getValue().toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError)
            {

            }
        });








    }
}
