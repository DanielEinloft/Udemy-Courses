package com.example.thami.listadetarefas.activity;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.thami.listadetarefas.R;
import com.example.thami.listadetarefas.helper.TarefaDAO;
import com.example.thami.listadetarefas.model.Tarefa;

public class AdicionarTarefaActivity extends AppCompatActivity
{

    private TextInputEditText editTarefa;
    private Tarefa tarefaAtual;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adicionar_tarefa);
        editTarefa = findViewById(R.id.textTarefa);

        //recuperar tarefa, caso seja edicao
        tarefaAtual = (Tarefa) getIntent().getSerializableExtra("tarefaSelecionada"); //cast pq ele achou um serializable e nao uma tarefa:)

        //exibir o texto original quando clicar na recuperacao. LOGO é EDICAO E NAO INSERIR
        if(tarefaAtual != null)
        {
            editTarefa.setText(tarefaAtual.getNomeTarefa());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_add_tarefa,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        switch (item.getItemId())
        {
            case R.id.itemSalvar:
                //Toast.makeText(AdicionarTarefaActivity.this,"Botão salvar pressionado", Toast.LENGTH_SHORT).show();
                TarefaDAO tarefaDAO = new TarefaDAO(getApplicationContext());
                //Data Access Object: padrao pra salvar e recuperar dados
                Tarefa tarefa  = new Tarefa();


                if(tarefaAtual !=null) //EDICAO
                {
                    String nomeT = editTarefa.getText().toString();
                    if(!nomeT.isEmpty())
                    {
                        Tarefa t = new Tarefa();
                        t.setNomeTarefa(nomeT);
                        t.setId(tarefaAtual.getId());

                        //atualizar no banco de dados

                        if(tarefaDAO.atualizar(t))
                        {
                            finish();//fechar activity
                            Toast.makeText(AdicionarTarefaActivity.this,"Sucesso ao atualizar tarefa", Toast.LENGTH_SHORT).show();
                        }
                        else
                        {
                            Toast.makeText(AdicionarTarefaActivity.this,"Erro ao atualizar tarefa", Toast.LENGTH_SHORT).show();

                        }
                    }
                }
                else //SALVANDO
                {


                    String nomeT = editTarefa.getText().toString();
                    if(!nomeT.isEmpty())
                    {
                        //tarefa.setNomeTarefa("Ir ao mercado");
                        tarefa.setNomeTarefa(nomeT);

                        if(tarefaDAO.salvar(tarefa))
                        {
                            finish();//fechar activity
                            Toast.makeText(AdicionarTarefaActivity.this,"Sucesso ao salvar tarefa", Toast.LENGTH_SHORT).show();
                        }
                        else
                            Toast.makeText(AdicionarTarefaActivity.this,"Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();

                    }
                }


                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
