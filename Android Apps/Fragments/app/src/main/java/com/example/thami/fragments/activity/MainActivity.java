package com.example.thami.fragments.activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.thami.fragments.R;
import com.example.thami.fragments.fragment.ContatosFragment;
import com.example.thami.fragments.fragment.ConversasFragment;

public class MainActivity extends AppCompatActivity
{

    private Button conversass, contatoss;
    private FrameLayout frameConteudo;
    private ConversasFragment conversasFragment;
    private ContatosFragment contatosFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        conversass = findViewById(R.id.conversass);
        contatoss = findViewById(R.id.contatoss);
        frameConteudo = findViewById(R.id.frameConteudo);




        //to usando support pra ser back compatible. Pro fragment, usar a versão support.v4 (aparece no auto complete)
        conversasFragment  = new ConversasFragment();
        //defina uma transacao e começa ela.
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        //se usa add ele coloca em cima. usar o recplace
        //transaction.add(R.id.frameConteudo, conversasFragment);
        transaction.replace(R.id.frameConteudo, conversasFragment);

        //depois que começa transacao, precisa finalizar. Definir as configuraçoes e dai da commit
        transaction.commit();





        contatoss.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                contatosFragment = new ContatosFragment();
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //se usa add ele coloca em cima. usar o recplace
                //transaction.add(R.id.frameConteudo,contatosFragment);
                transaction.replace(R.id.frameConteudo,contatosFragment);

                transaction.commit();
            }
        });



        conversass.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                conversasFragment = new ConversasFragment();

                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                //se usa add ele coloca em cima. usar o recplace
                //transaction.add(R.id.frameConteudo,contatosFragment);
                transaction.replace(R.id.frameConteudo,conversasFragment);

                transaction.commit();
            }
        });


        //remover sombra do actionbar
        getSupportActionBar().setElevation(0);
    }
}
