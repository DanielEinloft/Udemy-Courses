package com.example.thami.atmconsultoria;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;




import com.example.thami.atmconsultoria.fragment.ClientesFragment;
import com.example.thami.atmconsultoria.fragment.PrincipalFragment;
import com.example.thami.atmconsultoria.fragment.ServicosFragment;



//OUTRA FORMA DE FAZER A PÁGINA "SOBRE" USANDO UMA BIBLIOTECA EXTERNA. NO LINK: https://github.com/medyo/android-about-page
// colocar no gradle: compile 'com.github.medyo:android-about-page:1.2.2'


public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        //primeira tela = tela principal
        PrincipalFragment principalFragment = new PrincipalFragment();
        FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
        fragment.replace(R.id.frameContainer,principalFragment);
        fragment.commit();




        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                enviarEmail();
                //Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed()
    {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START))
        {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item)
    {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_principal)
        {
            PrincipalFragment principalFragment = new PrincipalFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer,principalFragment);
            fragment.commit();
        }
        else if (id == R.id.nav_servicos)
        {
            ServicosFragment servicosFragment = new ServicosFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer,servicosFragment);
            fragment.commit();
        }
        else if (id == R.id.nav_clientes)
        {
            ClientesFragment clientesFragment = new ClientesFragment();
            FragmentTransaction fragment = getSupportFragmentManager().beginTransaction();
            fragment.replace(R.id.frameContainer,clientesFragment);
            fragment.commit();
        }
        else if (id == R.id.nav_contato)
        {
            enviarEmail();
        }
        else if (id == R.id.nav_sobre)
        {
            startActivity(new Intent(this, activity_sobre.class));
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public void enviarEmail()
    {
        Intent email = new Intent(Intent.ACTION_SEND);

        //intent para email. Array de Strings: para enviar email apra mais de uma pessoa. Só colocar uma virgula:)
        email.putExtra(Intent.EXTRA_EMAIL,new String[] {"atmconsultoria@gmail.com"});
        //assunto do email
        email.putExtra(Intent.EXTRA_SUBJECT,"Contato pelo app");
        email.putExtra(Intent.EXTRA_TEXT,"Mensagem automática :)");

        //configurar para abrir os aplicativos de email. Se for imagem, setar png, video mp4, etc.
        email.setType("message/rfc822");//tipo para abrir aplicativos para envio de email :) Não tem o gmail no celular xP
        //email.setType("image/png");  //para abrir uma imagem, por ex.

        startActivity(Intent.createChooser(email,"Escolha o app de e-mail.")); //de acordo com o tipo setado acima, o proprio android vai localizar app pra esta extrutura


    }
}
