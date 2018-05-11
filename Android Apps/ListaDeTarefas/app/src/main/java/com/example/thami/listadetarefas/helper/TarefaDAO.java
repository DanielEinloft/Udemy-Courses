package com.example.thami.listadetarefas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.thami.listadetarefas.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by thami on 09/02/2018.
 */

public class TarefaDAO implements ITarefaDAO
{

    private SQLiteDatabase escreve;
    private SQLiteDatabase ler;

    public TarefaDAO(Context context)
    {
        DbHelper db = new DbHelper(context);
        ler = db.getReadableDatabase();
        escreve = db.getWritableDatabase();
    }

    @Override
    public boolean salvar(Tarefa tarefa)
    {
        ContentValues cv = new ContentValues();
        cv.put("nome", tarefa.getNomeTarefa());
        //cv.put("status", "E");//e = excluido


        try{
            //null -> so vai inserir os dados se a tarefa estiver preenchida :)
            escreve.insert( DbHelper.TABELA_TAREFAS,null ,cv);

        }catch (Exception e)
        {
            Log.i("erro", "erro ao salvar tarefa");
            return false;
        }

        return true;
    }

    @Override
    public boolean atualizar(Tarefa tarefa)
    {
        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa()); // atualiza o nome :)

        try{
            //precisa achar o id pra atualizar :). ? significa que vai ser substituido pelo proximo parametro. O próximo é um array pq pode ter varios parametros (id=5 AND status = balbal
            //String[] args = {"5","E"};
            //escreve.update(DbHelper.TABELA_TAREFAS,cv,"id=? AND status = ?",args);
            String[] args = {tarefa.getId().toString()};
            escreve.update(DbHelper.TABELA_TAREFAS,cv,"id=?",args);

            Log.i("erro", "OK :) ao atualizar tarefa");

        }catch (Exception e)
        {
            Log.i("erro", "erro ao atualizar tarefa");
            return false;
        }
        return true;
    }

    @Override
    public boolean deletar(Tarefa tarefa)
    {
        ContentValues cv = new ContentValues();
        cv.put("nome",tarefa.getNomeTarefa()); // atualiza o nome :)

        try{

            String[] args = {tarefa.getId().toString()};
            escreve.delete(DbHelper.TABELA_TAREFAS, "id=?",args);
            Log.i("erro", "OK :) ao deletar tarefa");

        }catch (Exception e)
        {
            Log.i("erro", "erro ao deletar tarefa");
            return false;
        }
        return true;
    }

    @Override
    public List<Tarefa> listar() {
        List<Tarefa> tarefas = new ArrayList<>();

        String sql = " SELECT * FROM " + DbHelper.TABELA_TAREFAS + " ;";//pega todos os dados
        Cursor c = ler.rawQuery(sql,null);//null -> sem filtros
        while(c.moveToNext())
        {
            Tarefa t = new Tarefa();
            Long id = c.getLong(c.getColumnIndex("id"));
            String nomeT = c.getString(c.getColumnIndex("nome"));
            t.setId(id);
            t.setNomeTarefa(nomeT);

            tarefas.add(t);
        }
        return tarefas;
    }
}
