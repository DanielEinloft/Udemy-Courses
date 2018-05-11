package com.example.thami.caraoucoroa;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity
{
    private ImageView imagem;
    private Button voltar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_main2);

        imagem = findViewById(R.id.resultado);
        voltar = findViewById(R.id.voltar);

        Bundle dados = getIntent().getExtras();
        int numero = dados.getInt("numero");

        if(numero == 0)
            imagem.setImageResource(R.drawable.moeda_cara);
        else
            imagem.setImageResource(R.drawable.moeda_coroa);

        voltar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                //Intent intent = new Intent(getApplicationContext(),Main2Activity.class);
                //startActivity(intent);

                finish(); //destroi a atividade.

            }
        });

    }

}
