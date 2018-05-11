package com.example.thami.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    private Button enviar;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(), "On create",Toast.LENGTH_SHORT).show();
        enviar = findViewById(R.id.enviar);


        //evento de click. Nao é possivel inicializar uma interface, então se cria uma classe anônima que dentro dela via ser implementado ométodo de click
        //se quiser pode criar outro método também, funciona das duas maneiras :)
        enviar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                //clica  no botao e abre a nova activity
                Intent intent = new Intent(getApplicationContext(),Main2Activity.class);

                Usuario user = new Usuario("daniel", "daniel.einloft@acad.pucrs.br");
                //precisa converter o objeto para "serializable". Ele permite serializar a o objeto (basicamente, fazer um streaming). É necessario implementar a interface Serializable na classe
                intent.putExtra("objeto",user);

                //passar dados. manda uma string
                //intent.putExtra("nome", "Daniel");
                //intent.putExtra("idade", 25);

                startActivity(intent);
            }
        });
    }

}
