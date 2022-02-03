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
import com.ilxbrasil.ingressos.beans.RetornoValidacao;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.servidor.ServidorTeste;
import com.ilxbrasil.ingressos.servidor.ServidorValidacao;
import com.ilxbrasil.ingressos.util.Comuns;


public class Tela_InformaCodigo extends Tela {



    private EditText codigo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_informa_codigo);

        this.codigo = (EditText)findViewById(R.id.tl_ifc_codigo);

        Button bt_validar = (Button) findViewById(R.id.tl_ifc_bt_validar);
        bt_validar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(validacao())
                    iniciaCarregamento();
            }
        });
    }





    public boolean validacao(){


        if(this.codigo==null || this.codigo.getText().length()!=12){

            Comuns.mensagem(tela, "Informe um código válido.");
            return false;
        }


        for(char letra: this.codigo.getText().toString().toCharArray()){

            if(letra!='0' && letra!='1' && letra!='2' && letra!='3' && letra!='4' && letra!='5' &&
                    letra!='6' && letra!='7' && letra!='8' && letra!='9'){

                Comuns.mensagem(tela, "Informe um código válido.");
                return false;
            }
        }

        return true;
    }





    public void carregando(){

        new ServidorValidacao().valida(this.tela, this.codigo.getText().toString());
    }





    public void retorno(Item retorno){

        desbloqueia();

        codigo.setText("");

        Intent i = new Intent(tela, Tela_ValidacaoResultado.class);
        i.putExtra("resultado", retorno!=null && retorno.getParam_t()!=null?(RetornoValidacao)retorno.getParam_t():null);
        this.startActivity(i);
    }




}