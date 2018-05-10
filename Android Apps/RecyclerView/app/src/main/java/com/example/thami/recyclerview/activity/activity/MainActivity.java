package com.example.thami.recyclerview.activity.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.thami.recyclerview.R;
import com.example.thami.recyclerview.activity.RecyclerItemClickListener;
import com.example.thami.recyclerview.activity.adapter.Adapter;
import com.example.thami.recyclerview.activity.model.Jogo;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private List<Jogo> games = new ArrayList<>();//
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);


        //listar filmes
        criarJogos();

        //adapter pega os dados e transforma (adapta, há!) no formato desejado
        //ESTE EH O ADAPTER QUE EU CRIEI ALI EM ADAPTER.JAVA!
        Adapter adapter = new Adapter(games);


        //configura recycle view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);//pra melhorar a performance. Vai ter um tamanho fixo:)
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));// cria os divisores pra linear layout
        recyclerView.setAdapter(adapter);


        //evento de clique. Pode fazer na mao o evento de clique. Vamos utilizarum tipo de clique que o google ja fez :). Tem que baixar! (ja coloquei aqui no projeto)
        //eh uma implementacao que o google recomenda
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener()
                {

                    //estas funcoes estao dentro do metodo OnItemClickListener()
                    @Override
                    public void onItemClick(View view, int position)
                    {
                        Jogo myGame  = games.get(position);
                        Toast.makeText(getApplicationContext(),"Item Pressionado " + myGame.getGames(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position)
                    {
                        Toast.makeText(getApplicationContext(),"Click Longo Pressionado", Toast.LENGTH_SHORT).show();
                    }

                    //nao vamos usar
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {}
                })

        );

    }
    public void criarJogos()
    {
        Jogo vg = new Jogo ("Final Fantasy", "RPG", "2010");
        this.games.add(vg);

        vg = new Jogo ("Metal Gear Solid", "Action/Stealth", "2010");
        this.games.add(vg);
        vg = new Jogo ("Mass Effect", "RPG", "2010");
        this.games.add(vg);
        vg = new Jogo ("Fallout", "RPG", "2010");
        this.games.add(vg);
        vg = new Jogo (" Uncharted", "Action", "2010");
        this.games.add(vg);
        vg = new Jogo ("Zelda", "Adventure", "2010");
        this.games.add(vg);
        vg = new Jogo (" Dark Souls", "Action RPG", "2010");
        this.games.add(vg);
        vg = new Jogo (" Spider-Man", "Action", "2010");
        this.games.add(vg);
        vg = new Jogo (" Breath of Fire", "RPG", "2010");
        this.games.add(vg);
        vg = new Jogo (" Divinity", "RPG", "2010");
        this.games.add(vg);
        vg = new Jogo (" Batman Arkkam", "Action", "2010");
        this.games.add(vg);
        vg = new Jogo (" The Last of Us", "", "2010");
        this.games.add(vg);




    }

}
