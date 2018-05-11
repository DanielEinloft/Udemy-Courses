package com.example.thami.listadetarefas.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thami.listadetarefas.R;
import com.example.thami.listadetarefas.model.Tarefa;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by thami on 09/02/2018.
 */

public class TarefaAdapter extends RecyclerView.Adapter<TarefaAdapter.MyViewHolder>
{

    private List<Tarefa> listaTarefas;

    //vai receber a lista de tarefas;s
    public TarefaAdapter(List<Tarefa> lista)
    {
        this.listaTarefas = lista;

    }


    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View itemLista = LayoutInflater.from(parent.getContext())
                                        .inflate(R.layout.lista_tarefa_adapter,parent,false);

        return new MyViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        Tarefa tarefa = listaTarefas.get(position);
        holder.tarefa.setText(tarefa.getNomeTarefa());

    }


    @Override
    public int getItemCount()
    {
        return this.listaTarefas.size();
    }






    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView tarefa;

        public MyViewHolder(View itemView)
        {
            super(itemView);
            tarefa = itemView.findViewById(R.id.textTarefa);

        }
    }


}
