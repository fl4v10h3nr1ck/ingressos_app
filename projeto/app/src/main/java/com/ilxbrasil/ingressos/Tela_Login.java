package com.ilxbrasil.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.servidor.ServidorUsuario;
import com.ilxbrasil.ingressos.util.Comuns;


public class Tela_Login extends Tela {



    private EditText usuario;

    private EditText senha;




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_login);

        this.usuario = (EditText)findViewById(R.id.tl_lgn_usuario);

        this.senha = (EditText)findViewById(R.id.tl_lgn_senha);


        Button bt_entrar = (Button) findViewById(R.id.tl_lgn_bt_entrar);
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validacao())
                    iniciaCarregamento();
            }
        });
    }





    public boolean validacao(){


        if(this.usuario.getText().length()<3){

            Comuns.mensagem(tela, "Informe o nome de usuário.");
            return false;
        }


        if (this.senha.getText().length() < 6) {

            Comuns.mensagem(tela, "A senha deve ter entre 6 e 16 dígitos.");
            return false;
        }

        return true;
    }





    public void carregando(){

        new ServidorUsuario().logar(this.tela, usuario.getText().toString(), senha.getText().toString());
    }





    public void retorno(Item retorno){

        this.desbloqueia();

        if(retorno!=null && retorno.getParam_int()>0){

            Comuns.setValoresIniciais(this.tela);

            Intent i = new Intent(tela, Tela_Abertura.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
            return;
        }

        ((TextView) this.findViewById(R.id.tl_lgn_erro)).setText("Usuário ou senha inválidos.");
    }




}