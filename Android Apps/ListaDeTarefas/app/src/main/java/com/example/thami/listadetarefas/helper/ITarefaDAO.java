package com.example.thami.listadetarefas.helper;

import com.example.thami.listadetarefas.model.Tarefa;

import java.util.List;

/**
 * Created by thami on 09/02/2018.
 */

public interface ITarefaDAO
{
    public boolean salvar(Tarefa tarefa);
    public boolean atualizar(Tarefa tarefa);
    public boolean deletar(Tarefa tarefa);
    public List<Tarefa> listar();
}
