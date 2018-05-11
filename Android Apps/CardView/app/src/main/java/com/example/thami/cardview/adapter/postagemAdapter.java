package com.example.thami.cardview.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.thami.cardview.R;
import com.example.thami.cardview.model.Postagem;

import java.util.List;

/**
 * Created by thami on 01/02/2018.
 */

//novamente, fazer outra inner classe para o viewholder (RecyclerView.Adapter<MyViewHolder>)
public class postagemAdapter extends RecyclerView.Adapter<postagemAdapter.MyViewHolder>
{

    private List<Postagem> postagens;
    public postagemAdapter(List<Postagem> p )
    {
        this.postagens = p;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        //pega o layout que a feito quando é criado.
        View itemList = LayoutInflater.from(parent.getContext()).inflate(R.layout.postagem_detalhe,parent, false);

        //envia um myviewholder definido ali em baixo com construtor.
        return new MyViewHolder(itemList);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position)
    {

        Postagem post = postagens.get(position);
        holder.textNom.setText(post.getNome());
        holder.textPostagem.setText(post.getPostagem());
        holder.imagemPostagem.setImageResource(post.getImagem());

    }

    @Override
    public int getItemCount()
    {
        return postagens.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        private TextView textNom;
        private TextView textPostagem;
        private ImageView imagemPostagem;


        public MyViewHolder(View itemView)
        {
            super(itemView);
            textNom = itemView.findViewById(R.id.textNome);
            textPostagem = itemView.findViewById(R.id.textPostagem);
            imagemPostagem = itemView.findViewById(R.id.imagePostagem);
        }


    }


}
