package com.example.thami.sharedpreferences;

import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private TextInputEditText textInputEditText;
    private Button salvar;
    private TextView text;
    //static vai ser o mesmo pra todas as instancias da classe
    private static final String ARQUIVO_PREFERENCIA = "arquivo preferencia";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text = findViewById(R.id.textresultado);
        textInputEditText = findViewById(R.id.editNome);
        salvar = findViewById(R.id.salvarbutton);



        salvar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //shared preferences cria arquivo xml que pode salvar informações :) NAO É UM BANCO DE DADOS
                //segundo argumento -> tipo: 0 : modo privado [so o app vai poder salvar eler o arquivo]
                SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);

                //edit -> retorno de um editor, pra fazer a edicao (dã). É por este objeto que a coisa acontece :P
                SharedPreferences.Editor editor = preferences.edit();

                //validar nome
                if(textInputEditText.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "Coloque um nome! >(", Toast.LENGTH_SHORT).show();
                else
                {
                    String nome = textInputEditText.getText().toString();
                    editor.putString("saved_name",nome);
                    editor.commit();
                    text.setText(nome);
                }
            }
        });

        //recuperar os dados
        SharedPreferences preferences = getSharedPreferences(ARQUIVO_PREFERENCIA,0);
        if(preferences.contains("saved_name"))
        {
            String nome = preferences.getString("saved_name","unknown");
            text.setText(nome);

        }
        else
            Toast.makeText(getApplicationContext(), "Coloque um nome! >(", Toast.LENGTH_SHORT).show();



    }
}
