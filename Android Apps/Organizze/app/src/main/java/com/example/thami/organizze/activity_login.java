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
import com.google.firebase.auth.FirebaseAuthInvalidUserException;

public class activity_login extends AppCompatActivity
{

    private EditText campoEmail,campoSenha;
    private Button botaoEntrar;
    private Usuario usuario;
    private FirebaseAuth autenticacao;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        campoEmail= findViewById(R.id.editEmail2);
        campoSenha = findViewById(R.id.editSenha2);
        botaoEntrar = findViewById(R.id.buttonEntrar);

        botaoEntrar.setOnClickListener(new View.OnClickListener()
        {
            String textoEmail =  campoEmail.getText().toString();
            String textoSenha =  campoSenha.getText().toString();

            @Override
            public void onClick(View view)
            {
                if(!textoEmail.isEmpty())
                {
                    if(!textoSenha.isEmpty())
                    {
                        usuario = new Usuario();
                        usuario.setSenha(textoSenha);
                        usuario.setEmail(textoEmail);

                        ValidarLogin();
                    }
                    else
                        Toast.makeText(activity_login.this, "Preencha o senha!", Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(activity_login.this, "Preencha o Email!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void ValidarLogin()
    {
            autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
            autenticacao.signInWithEmailAndPassword(usuario.getEmail(),usuario.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>()
            {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task)
                {
                    if(task.isSuccessful())
                    {
                        Toast.makeText(activity_login.this, "Sucesso ao fazer login!", Toast.LENGTH_SHORT).show();

                    }
                    else
                    {
                        String excecao = "";
                        try{
                            throw task.getException();
                        }catch (FirebaseAuthInvalidCredentialsException e)
                        {
                            excecao = "Digite um e-mail e senha válido";
                        }catch (FirebaseAuthInvalidUserException e) {
                            excecao = " User nao existe";
                        }catch (Exception e)
                        {
                            excecao = "Erro ao cadastrar user " + e.getMessage();
                            e.printStackTrace();
                        }
                        Toast.makeText(activity_login.this, excecao, Toast.LENGTH_SHORT).show();

                    }
                }
            });
    }


}
