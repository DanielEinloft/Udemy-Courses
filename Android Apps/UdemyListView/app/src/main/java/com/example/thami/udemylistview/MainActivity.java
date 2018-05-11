package com.example.thami.udemylistview;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    private ListView listView;
    private String[] itens = {"Final Fantasy", "Metal Gear Solid", "Mass Effect", "Fallout", "Uncharted", "Dark Souls", "Zelda", "Half Life","Spider-Man", "The Last of Us"," Batman Arkkam", "Breath of Fire", "Divinity"};
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView  = findViewById(R.id.listLocais);

        //cria adaptador para a lista (pq os itens podem variar)
        // o  simple_list_item_1 é basicamente um layout com textView. Tipo, literalmente
        //pq text1? segura ctrl e clica no simples_list_item_1 e abre o xml. O textview tem o id text1.
        ArrayAdapter<String> adaptador =  new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,itens)
        {
            //isso tudo é so pra mudar a cor do texto pra preto... '-'
            @Override
            public View getView(int position, View convertView, ViewGroup parent)
            {
                //pega a view do pai (constraint view?)
                View view = super.getView(position, convertView, parent);

                //pega o texto
                TextView textView = (TextView) view.findViewById(android.R.id.text1);

                /*YOUR CHOICE OF COLOR*/
                textView.setTextColor(Color.BLACK);

                return view;
            }
        };



        //adiciona adaptador na lista
        listView.setAdapter(adaptador);

        //adicionar click na lista
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l)
            {
                //i -> posicao de cada item na lista
                //l -> id do componente
                String valorSelecionado = listView.getItemAtPosition(i).toString();
                Toast.makeText(getApplicationContext(), valorSelecionado,Toast.LENGTH_LONG).show();

            }
        });

    }


}

