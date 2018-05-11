package com.example.thami.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity
{
    private TextView textnome;
    private TextView textidade;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        textnome = findViewById(R.id.textnome);
        textidade = findViewById(R.id.textidade);

        //recuperar dados. Bundle permite recuperar os dados enviados.
        //Bundle dados =  getIntent().getExtras();
        //String nome = dados.getString("nome");
        //int idade = dados.getInt("idade");



        //textnome.setText(nome);
        //textidade.setText(String.valueOf(idade));


        Bundle dados = getIntent().getExtras();
        Usuario user =  (Usuario) dados.getSerializable("objeto");
        textnome.setText(user.getNome());
        textidade.setText(user.getEmail());

    }


}
