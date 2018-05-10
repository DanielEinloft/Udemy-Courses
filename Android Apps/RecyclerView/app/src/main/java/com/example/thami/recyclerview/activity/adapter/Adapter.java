package com.example.thami.recyclerview.activity.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thami.recyclerview.R;
import com.example.thami.recyclerview.activity.model.Jogo;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by thami on 01/02/2018.
 */



//este myviewholder eh o viewholder definido ali em baixo, que PRECISA ser do tipo viewholder. por isso que ele faz um extends do viewholder ali.
public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>
{
    private List<Jogo> lista;

    public Adapter(List<Jogo> lista )
    {
        this.lista = lista;
    }



    //chamado para criar as visualizaçoes. So cria as views que sao feitas para o usuario.
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        // eh preciso criar um layout xml pra ter a estrutura bonita que quer ter
        //inflater pega um xml e converte pra uma visualizaçao. Pega o contexto baseado no componente que o item de lista ta dentro (adaptador)
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_lista,parent,false);

        //eh o viewholder que vai mostrar os dados dentro da nossa visualizacao
        //nao exibe nada, apenas CRIA a visualizacao
        return new MyViewHolder(itemList);
    }

    //se ja abriu todas as opcoes, ele nao cria tudo de novo quando sobe a lista de novo. Ele usa esta funcao para recarregar apenas
    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {
        //se size = 10, vai ser chamado 10x, enquanto eles APARECEM.
        //o holder eh o retornado do oncreate, definido na classe ali em baixo
        Jogo jogo = lista.get(position);
        holder.game.setText(jogo.getGames());
        holder.gameGenero.setText(jogo.getGamesGeneros());
        holder.ano.setText(jogo.getGamesAnos());

    }

    @Override
    public int getItemCount()
    {
        return lista.size();
    }




    //classe dentro da classe :P
    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView game;
        TextView gameGenero;
        TextView ano;
        //vai guardar cada um dos dados para serem exibidos na tela.
        public MyViewHolder(View itemView)
        {
            super(itemView);
            //ja tem a view do pai

            game = itemView.findViewById(R.id.gameText);
            gameGenero = itemView.findViewById(R.id.gameGenero);
            ano = itemView.findViewById(R.id.gameAno);



        }
    }

}
