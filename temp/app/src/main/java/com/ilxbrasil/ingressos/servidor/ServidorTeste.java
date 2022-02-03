package com.ilxbrasil.ingressos.servidor;

import android.util.Log;

import com.ilxbrasil.ingressos.DAO.DAO;
import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.beans.RetornoVazio;
import com.ilxbrasil.ingressos.beans.Usuario;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.util.Comuns;

import java.util.HashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Response;


/**
 * Created by fl4v10 on 03/10/2016.
 */

public class ServidorTeste extends Servidor {




    public void testeDeConexao(final Tela tela){


        if(Comuns.mostrarLog)
            Log.i("SERV_PARAM TstDeConexao", "");

        Interface inter = retrofit.create(Interface.class);

        Call<MSG<RetornoVazio>> call = inter.testeDeConexao(
                                                this.CV,
                                                "TesteDeConexao",
                                                    null);

        Retorno<RetornoVazio> retorno = new Retorno<RetornoVazio>(tela){

            @Override
            public void retorno(Response<MSG<RetornoVazio>> response) {

                tela.retorno(new Item());
            }

            public void emCasoDeErro(){

                Comuns.ip_servidor = null;

                tela.retorno(null);
            }
        };

        call.enqueue(retorno);

        return;
    }


}