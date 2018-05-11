package com.example.thami.menus;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        //inflar menus pra converter arquivo xml para um tipo view
        getMenuInflater().inflate(R.menu.menu_principal,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemSalvar:
                Toast.makeText(MainActivity.this,"item salvar", Toast.LENGTH_LONG);
                break;
            case R.id.itemEditar:
                Toast.makeText(MainActivity.this,"item edit", Toast.LENGTH_LONG);
                break;
            case R.id.itemConfiguraçoes:
                Toast.makeText(MainActivity.this,"item config", Toast.LENGTH_LONG);
                break

        }
        return super.onOptionsItemSelected(item);
    }
}
