package com.example.thami.utilizarabas_threads;

import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.thami.utilizarabas_threads.fragment.EmAltaFragment;
import com.example.thami.utilizarabas_threads.fragment.HomeFragment;
import com.example.thami.utilizarabas_threads.fragment.InscricoesFragment;
import com.ogaclejapan.smarttablayout.SmartTabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

//IMPORTAR BIBLIOTECA : https://github.com/ogaclejapan/SmartTabLayout/
public class MainActivity extends AppCompatActivity
{

    private ViewPager viewPager;
    private SmartTabLayout smartTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = findViewById(R.id.viewPager);
        smartTabLayout = findViewById(R.id.viewPagerTab);



        //aplica configuracoes na action bar
        getSupportActionBar().setElevation(0); //tirar a pequena sombra da parte de cima
        getSupportActionBar().setTitle("Yotube:)");




        //conigurar abas. Vai criar fragments (3) em cada aba :)
        FragmentPagerAdapter adapter = new FragmentPagerItemAdapter(
          getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Home", HomeFragment.class)
                .add("Em Alta", EmAltaFragment.class)
                .add("Inscricoes", InscricoesFragment.class)
                .create()

        );
        viewPager.setAdapter(adapter);
        smartTabLayout.setViewPager(viewPager);
    }
}
