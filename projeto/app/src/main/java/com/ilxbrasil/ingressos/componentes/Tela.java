package com.ilxbrasil.ingressos.componentes;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.multidex.MultiDex;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.ilxbrasil.ingressos.R;
import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.util.Comuns;


/**
 * Created by fl4v10 on 02/12/2016.
 */

public abstract class Tela<T> extends AppCompatActivity{



    private volatile boolean bloqueado;

    private ProgressDialog load;

    public Tela tela;




    public Tela(){

        this.tela = this;

        this.desbloqueia();
    }



    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);
    }




    public void carregando(){}





    public void retorno(Item<T> retorno){}






    public final void bloqueia(){

        if(load!=null)
            this.load.show();

        this.bloqueado = true;
    }





    public final void desbloqueia(){

        if(load!=null)
            this.load.dismiss();

        this.bloqueado = false;
    }






    public final void iniciaCarregamento() {

        this.iniciaCarregamento(true, null);
    }





    public final void iniciaCarregamento(String rotulo) {

        this.iniciaCarregamento(true, rotulo);
    }





    public final void iniciaCarregamento(boolean mostrarProgresso) {

        this.iniciaCarregamento(mostrarProgresso, null);
    }






    public final void iniciaCarregamento(boolean mostrarProgresso, String rotulo) {


        if(!mostrarProgresso)
            carregando();
        else {

            load  = new ProgressDialog(this);
            load.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            load.setMessage(Comuns.temConteudo(rotulo)?rotulo:"Aguarde...");
            load.setCancelable(false);
            load.setCanceledOnTouchOutside(false);

            bloqueia();

            carregando();
        }
    }






    public void seOcorrerUmErro(String parametro){

        this.desbloqueia();
    }






    public void setTelaDeErro(){

        this.desbloqueia();

        setContentView(R.layout.tl_erro);

        Button bt_voltar = (Button) findViewById(R.id.bt_voltar_tela_erro);

        bt_voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                acaoBotaoVoltarDeTelaDeErro();
            }
        });
    }






    public void acaoBotaoVoltarDeTelaDeErro(){

        finish();
    }




    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {

        retornoDePermissao(requestCode);

        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }





    public void retornoDePermissao(int permissao_pedida){}




}
