package com.ilxbrasil.ingressos.servidor;


import android.content.Context;
import android.util.Log;

import com.ilxbrasil.ingressos.R;
import com.ilxbrasil.ingressos.util.Comuns;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * Created by fl4v10 on 03/10/2016.
 */

public abstract class Retorno<T> implements Callback<MSG<T>> {


    private Context contexto;




    public Retorno(Context contexto){

    this.contexto  =contexto;
    }




    public abstract void retorno(Response<MSG<T>> response);






    @Override
    public void onResponse(Call<MSG<T>> call, Response<MSG<T>> response) {

        if(Comuns.mostrarLog)
            Log.i("CONEC OK", "OK");

        if(response==null || response.body()==null || response.body().getStatus()==null) {
            this.erro(getContexto().getString(R.string.erro_de_conexao));
            return;
        }

        if(Comuns.mostrarLog)
            Log.i("ERRO", "STT: "+response.body().getStatus()+" MSG: "+response.body().getMsg());

        if(response.body().getStatus().compareTo("OK")==0)
            this.retorno(response);
        else
            this.erro(response.body().getMsg());
    }





    @Override
    public void onFailure(Call<MSG<T>> call, Throwable t) {

        if(Comuns.mostrarLog)
            Log.i("CONEC FALHOU", "FALHOU");

        this.erro(getContexto().getString(R.string.erro_de_conexao));
    }





    public void erro(String mensagem){

        this.emCasoDeErro();
    }




    public void emCasoDeErro(){}





    public Context getContexto(){

        return this.contexto;
    }



}
