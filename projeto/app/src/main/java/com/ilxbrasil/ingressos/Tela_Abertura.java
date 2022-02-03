package com.ilxbrasil.ingressos;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.servidor.ServidorTeste;
import com.ilxbrasil.ingressos.util.Comuns;
import com.ilxbrasil.ingressos.util.Data;
import com.ilxbrasil.ingressos.util.Permissao;


public class Tela_Abertura extends Tela {



    private final int TEMPO_ESPERA = 1000;




    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_abertura);

        Comuns.setValoresIniciais(this);

        Comuns.setDimensoes(this);

        ((TextView) findViewById(R.id.tl_abt_lb_copyright)).setText(String.format(this.getString(R.string.tl_abt_lb1), Data.getAnoAtual()));

        ((TextView) findViewById(R.id.tl_abt_lb_status)).setText("Aguarde...");

        new Thread(new Espera()).start();
    }




    public void carregando(){

        if(Comuns.ip_servidor!=null)
            new ServidorTeste().testeDeConexao(this);
        else
            retorno(null);
    }





    public void retorno(Item retorno) {

        desbloqueia();

        prontoParaIniciar(retorno!=null);
    }






    private void prontoParaIniciar(boolean pronto){

        Intent i;

        if(pronto) {

            if (Comuns.usuarioAtual == null)
                i = new Intent(tela, Tela_Login.class);
            else
                i = new Intent(tela, Tela_Principal.class);
        }
        else
            i = new Intent(tela, Tela_Conecta.class);

        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        this.startActivity(i);
    }






    public class Espera implements Runnable {


        public void run () {

            try{

                Thread.sleep(TEMPO_ESPERA);

                iniciaCarregamento(false);

            }catch (Exception e){}

        }
    }


}
