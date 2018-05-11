package com.example.thami.listadetarefas.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by thami on 09/02/2018.
 */

public class DbHelper extends SQLiteOpenHelper
{
    public static int VERSION = 1;
    //public static int VERSION = 2;
    public static String name = "DB_TAREFAS";
    public static String TABELA_TAREFAS  = "tarefas";

    //precisa do context
    public DbHelper(Context context)
    {
        super(context, name, null, VERSION);

    }

    //vai ser chamado quando o user INSTALAR a tabela.
    @Override
    public void onCreate(SQLiteDatabase db)
    {
        String sql  = "CREATE TABLE IF NOT EXISTS " + TABELA_TAREFAS + " (id INTEGER PRIMARY KEY AUTOINCREMENT, nome TEXTO NOT NULL);";

        try
        {
            //colocar aqui a criação de todas as tabelas :)
            db.execSQL(sql);
        }catch (Exception e)
        {
            Log.i("INFO DB", "ERO AO CRIAR TABELA " +e.getMessage());
        }
    }


    //se mudar a versão do update, colocar V=2 e quando re instalar ele vai executar esta função :)
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1)
    {
        String sql  = "DROP TABLE IF EXISTS " + TABELA_TAREFAS + " ;"; //deletar tabela
        //String sql  = "ALTER TABLE "+ TABELA_TAREFAS+ " ADD COLUMN status VARCHAR(1) "; //adicionando uma nova coluna :B

        try
        {            //colocar aqui a criação de todas as tabelas :)
            db.execSQL(sql);
            onCreate(db); //pra caso queira deletar e fazer outra :3
        }catch (Exception e)
        {
            Log.i("INFO DB", "ERRO AO dar update TABELA " +e.getMessage());
        }
    }
}
