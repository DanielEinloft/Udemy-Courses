package com.example.thami.sqlite;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //banco de dados PRECISA ficar dentro de um trycatch pra garantir que não dê erro
        try
        {
            //abre ou cria. so o app vai acessar (private)
            SQLiteDatabase bancoDados = openOrCreateDatabase("app",MODE_PRIVATE, null);



            //--------------------------------------------------tipo 1--------------------------------------------------
            //----------------------------------------------------------------------------------------------------
            //criar tabela. duas colunas: nome e idade (inteiro com 3 digitos)
            //bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (nome VARCHAR , idade INT(3))");


            //inserir dados. Se ficar executando toda vez que abrir vai adicionar as pessoas. <o>
            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Daniel',25)");
            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Isadora',24)");
            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Mamae',59)");
            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Papae',150)");

            //----------------------------------------atualizar usando update
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19 WHERE nome = 'Papae'");
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Papae Quilido' WHERE nome = 'Papae'");



            //----------------------------------FORMAS DE FILTRO
             //String consulta  = "SELECT nome, idade FROM pessoas WHERE nome = 'Daniel'";//ssim aparece so o daniiii
            //String consulta  = "SELECT nome, idade FROM pessoas WHERE nome = 'Daniel' AND idade  = 25";
            //String consulta  = "SELECT nome, idade FROM pessoas WHERE idade > 25  ";
            //String consulta  = "SELECT nome, idade FROM pessoas WHERE idade IN(24,30) "; //pessoas com idades 24 e30
            //String consulta  = "SELECT nome, idade FROM pessoas WHERE idade BETWEEN 24 AND 30"; //entre
            //String consulta  = "SELECT nome, idade FROM pessoas WHERE nome LIKE daniel"; //parecido. Legal que da pra usar coisas tipo dan%, pra pegar dan + qualquer coisa :P

//            String consulta  = "SELECT nome, idade FROM pessoas WHERE nome LIKE '%" + filtro + %'"; //parecido. Legal que da pra usar coisas tipo dan%, pra pegar dan + qualquer coisa :P

//            String consulta  = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC";//1=1 pra começar so, sempre true... coloca em ordem de idade...pode ser ASC( aumentando) e DESC (dimin)

//            String consulta  = "SELECT nome, idade FROM pessoas WHERE 1=1 ORDER BY idade ASC LIMIT 3";//mostrar apenas 3
            //String consulta  = "SELECT nome, idade FROM pessoas




            //--------------------------------------------------tipo 2:--------------------------------------------------
            //----------------------------------------------------------------------------------------------------
            //bancoDados.execSQL("DROP TABLE pessoas"); //apaga a tabela! :o COMENTAR DEPOIS QUE APAGAR
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT,nome VARCHAR , idade INT(3))"); //integer => chave primaria nao pode se repetir, por isso usa primary key

            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Isadora',24)");
            //bancoDados.execSQL("INSERT INTO  pessoas(nome ,idade) VALUES  ('Dani',25)");
            //bancoDados.execSQL("UPDATE pessoas SET idade = 19, nome = 'Papae Quilido' WHERE id = 3");
            //bancoDados.execSQL("DELETE FROM pessoas WHERE id = 3");
            bancoDados.execSQL("DELETE FROM pessoas"); //deleta tudo :)





            //--------------------------
            //com id:
            //String consulta  = "SELECT id,nome, idade FROM pessoas";
            String consulta  = "SELECT * FROM pessoas"; // * -> todos os campos.Cuidado pois pega mta memória!


            //sem id:
            //String consulta  = "SELECT id,nome, idade FROM pessoas";

            //recuperar pessoas. Cursor é uma linha
            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //indices da tabela
            //com id:
            int indiceid  = cursor.getColumnIndex("id");
            int indiceNome  = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            cursor.moveToFirst();//forçar pra ir no começo.
            //percorre lista
            while(cursor != null)
            {
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);
                //com id:
                String id = cursor.getString(indiceid);


                Log.i("Resultado - id: ", id + " /nome: "+  nome +  " / idade " + idade);
//                Log.i("Resultado - idade: ",cursor.getString(indiceIdade));
                cursor.moveToNext();
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
