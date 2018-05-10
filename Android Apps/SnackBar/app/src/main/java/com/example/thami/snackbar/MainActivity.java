package com.example.thami.snackbar;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{
    private Button buttonAbrir;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        buttonAbrir = findViewById(R.id.buttonAbrir);


        buttonAbrir.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Snackbar.make(view,"Botão Pressionado",Snackbar.LENGTH_LONG).setAction("Confirmar", new View.OnClickListener()
                {
                    @Override
                    public void onClick(View view)
                    {
                        buttonAbrir.setText("Botão Alterado");
                    }
                }).setActionTextColor(getResources().getColor(R.color.colorPrimary)).show();//tipo o toast. Tá aqui pq antes de chamar o show, é chamado o setAction (que abre o método a ser implementado).
            }
        });

    }
}
