package com.example.thami.cardview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;

import com.example.thami.cardview.R;
import com.example.thami.cardview.adapter.postagemAdapter;
import com.example.thami.cardview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens= new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerPostagem = findViewById(R.id.recyclerPostagem);


        //define layout Linear
        //LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        //layoutManager.setOrientation(LinearLayout.HORIZONTAL); // scroll pros lados
        //layoutManager.setOrientation(LinearLayout.VERTICAL); //scroll para cima e baixo

        //Define layout grid layout manager
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
        recyclerPostagem.setLayoutManager(layoutManager);


        //define adapter
        prepararPostagens();
        postagemAdapter adapter = new postagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);

    }


    public void prepararPostagens()
    {
        Postagem p = new Postagem("Daniel","aeaea", R.drawable.imagem1);
        postagens.add(p);
        p = new Postagem("Daniel1","aea21321ea", R.drawable.imagem2);
        postagens.add(p);
        p = new Postagem("Danie2l","aea12321ea", R.drawable.imagem3);
        postagens.add(p);
        p = new Postagem("Daniel3","aeae32a", R.drawable.imagem4);
        postagens.add(p);
    }


}
