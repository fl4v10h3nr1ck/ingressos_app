package com.ilxbrasil.ingressos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ilxbrasil.ingressos.DAO.DAO;
import com.ilxbrasil.ingressos.beans.Ip;
import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.servidor.ServidorTeste;
import com.ilxbrasil.ingressos.servidor.ServidorUsuario;
import com.ilxbrasil.ingressos.util.Comuns;


public class Tela_Conecta extends Tela {



    private EditText ip;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_conecta);

        this.ip = (EditText)findViewById(R.id.tl_cnt_ip);


        Button bt_entrar = (Button) findViewById(R.id.tl_cnt_bt_entrar);
        bt_entrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validacao())
                    iniciaCarregamento();
            }
        });
    }





    public boolean validacao(){


        if(this.ip.getText().length()<8){

            Comuns.mensagem(tela, "Informe um IP válido.");
            return false;
        }


        for(char letra: this.ip.getText().toString().toCharArray()){

            if(letra!='0' && letra!='1' && letra!='2' && letra!='3' && letra!='4' && letra!='5' &&
                    letra!='6' && letra!='7' && letra!='8' && letra!='9' && letra!='.'){

                Comuns.mensagem(tela, "Informe um IP válido.");
                return false;
            }
        }

        return true;
    }





    public void carregando(){

        Comuns.ip_servidor = new Ip();
        Comuns.ip_servidor.setIp(this.ip.getText().toString());

        new ServidorTeste().testeDeConexao(this.tela);
    }





    public void retorno(Item retorno){

        this.desbloqueia();

        if(retorno!=null){

            DAO<Ip> dao = new DAO<Ip>(Ip.class, this);

            dao.remove("id>0");

            Ip novo = new Ip();

            novo.setIp(this.ip.getText().toString());

            dao.novo(novo);

            Intent i = new Intent(tela, Tela_Abertura.class);
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(i);
            finish();
            return;
        }

        ((TextView) this.findViewById(R.id.tl_cnt_erro)).setText(R.string.cnt_lb2);
    }




}