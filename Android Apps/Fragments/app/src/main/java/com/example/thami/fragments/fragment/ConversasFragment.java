package com.example.thami.fragments.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.thami.fragments.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConversasFragment extends Fragment
{
    private TextView conversa;

    public ConversasFragment()
    {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        //pega o fragmento, transforma numa view e retorna exibindo para o userusuário.
        View view =  inflater.inflate(R.layout.fragment_conversas, container, false);
        conversa = view.findViewById(R.id.conversa);
        return view;
    }

}
