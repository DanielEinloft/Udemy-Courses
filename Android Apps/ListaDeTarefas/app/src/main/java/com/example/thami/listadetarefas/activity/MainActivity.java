package com.example.thami.listadetarefas.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.thami.listadetarefas.R;
import com.example.thami.listadetarefas.adapter.TarefaAdapter;
import com.example.thami.listadetarefas.helper.DbHelper;
import com.example.thami.listadetarefas.helper.RecyclerItemClickListener;
import com.example.thami.listadetarefas.helper.TarefaDAO;
import com.example.thami.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TarefaAdapter tarefaAdapter;
    private List<Tarefa> listaTarefas = new ArrayList<>();
    private Tarefa tarefaSelecionada;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerLista);


        //setting up data base :O
        /*DbHelper db = new DbHelper(getApplicationContext());
        ContentValues cv = new ContentValues();
        cv.put("nome", "Valor teste");
        db.getWritableDatabase().insert("tarefas",null,cv);
*/


        //adicionar evento de clique
        recyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(getApplicationContext(), recyclerView, new RecyclerItemClickListener.OnItemClickListener()
                {
                    @Override
                    public void onItemClick(View view, int position)
                    {
                        //recuperar tarefa pra edicao
                        Tarefa tarefaSelecionada = listaTarefas.get(position);

                        //enviar tarefa para tela add tarefa
                        Intent intent  = new Intent(MainActivity.this,AdicionarTarefaActivity.class);
                        intent.putExtra("tarefaSelecionada",tarefaSelecionada); //PRECISA TER SERIALIZABLE NO TAREFA
                        startActivity(intent);
                    }

                    @Override
                    public void onLongItemClick(View view, int position)
                    {
                        //recuperar tarefa para deletar
                        tarefaSelecionada = listaTarefas.get(position);

                        AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);

                        //configurar titulo e mensagem
                        dialog.setTitle("Confirmar exclusão");
                        dialog.setMessage("Deseja excluir a terafa " + tarefaSelecionada.getNomeTarefa()+ " ?");

                        //positive button :)
                        dialog.setPositiveButton("SIM", new DialogInterface.OnClickListener()
                        {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i)
                            {
                                TarefaDAO tarefadao = new TarefaDAO(getApplicationContext());
                                if(tarefadao.deletar(tarefaSelecionada))
                                {
                                    carregarListaTarefas();//recarregar a lista!
                                    Toast.makeText(getApplicationContext(),"Tarefa deletada", Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(getApplicationContext(),"Erro ao deletar tarefa ", Toast.LENGTH_SHORT).show();

                                }
                            }
                        });

                        //negative button :) nao tem evento pra 'não':)
                        dialog.setNegativeButton("NÃO", null);

                        dialog.create();
                        dialog.show();
                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }
                )
        );



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(getApplicationContext(),AdicionarTarefaActivity.class);
                startActivity(intent);

            }
        });



    }



    public void carregarListaTarefas()
    {/*
        //listar tarefas
        Tarefa tarefa1 = new Tarefa();
        tarefa1.setNomeTarefa("Ir ao mercado");
        listaTarefas.add(tarefa1);

        Tarefa tarefa2 = new Tarefa();
        tarefa2.setNomeTarefa("Ir ao shopping");
        listaTarefas.add(tarefa2);
*/
        TarefaDAO tarefaDAO  = new TarefaDAO(getApplicationContext());
        listaTarefas = tarefaDAO.listar();

        //configurar adapter
        tarefaAdapter = new TarefaAdapter(listaTarefas);

        //configurar recycler view
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(tarefaAdapter);

    }



    //é chamado cada vez queo user sai e volta pra janela :)
    @Override
    protected void onStart()
    {
        super.onStart();
        carregarListaTarefas();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}
