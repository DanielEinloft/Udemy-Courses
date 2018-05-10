package com.example.thami.organizze;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.thami.organizze.config.ConfiguracaoFirebase;
import com.example.thami.organizze.model.Usuario;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class CadastroActivity extends AppCompatActivity
{


    private EditText campoNome,campoEmail,campoSenha;
    private Button botaoCadastrar;
    private FirebaseAuth autenticacao;
    private Usuario usuario;




    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        campoEmail = findViewById(R.id.editEmail);
        campoNome = findViewById(R.id.editNome);
        campoSenha = findViewById(R.id.editSenha);
        botaoCadastrar = findViewById(R.id.buttonCadastrar);

        botaoCadastrar.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String textoNome =  campoNome.getText().toString();
                String textoEmail =  campoEmail.getText().toString();
                String textoSenha =  campoSenha.getText().toString();

                if(!textoNome.isEmpty())
                {
                    if(!textoEmail.isEmpty())
                    {
                        if(!textoSenha.isEmpty())
                        {
                            usuario = new Usuario();
                            usuario.setEmail(textoEmail);
                            usuario.setNome(textoNome);
                            usuario.setSenha(textoSenha);
                            CadastrarUsuario();
                        }
                        else
                            Toast.makeText(CadastroActivity.this, "Preencha o senha!", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(CadastroActivity.this, "Preencha o Email!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(CadastroActivity.this, "Preencha o nome!", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void CadastrarUsuario()
    {
        autenticacao  = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.createUserWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(this, new OnCompleteListener<AuthResult>()
        {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task)
            {
                if(task.isSuccessful())
                    Toast.makeText(CadastroActivity.this, "Sucesso ao cadastrar usuário!", Toast.LENGTH_SHORT).show();
                else
                {
                    String excecao = "";
                    try{
                        throw task.getException();
                    }
                    catch (FirebaseAuthWeakPasswordException e)
                    {
                        excecao = " Digite uma senha mais forte!";
                    }catch (FirebaseAuthInvalidCredentialsException e)
                    {
                        excecao = "Digite um e-mail válido";
                    }catch (FirebaseAuthUserCollisionException e)
                    {
                        excecao = " Esta conta ja foi cadastrada";
                    }catch (Exception e)
                    {
                        excecao = "Erro ao cadastrar user " + e.getMessage();
                        e.printStackTrace();
                    }

                    Toast.makeText(CadastroActivity.this, excecao, Toast.LENGTH_SHORT).show();

                }


            }
        });
    }


}
