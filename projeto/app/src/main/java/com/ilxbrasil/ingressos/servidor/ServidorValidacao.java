package com.ilxbrasil.ingressos.servidor;

import android.util.Log;

import com.ilxbrasil.ingressos.DAO.DAO;
import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.beans.RetornoValidacao;
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

public class ServidorValidacao extends Servidor {




    public void valida(final Tela tela, String codigo){

        Map<String, String> map= new HashMap<>();
        map.put("codigo", codigo);

        String parametros = formaParametro(map);

        if(Comuns.mostrarLog)
            Log.i("SERV_PARAM Validacao", parametros);

        Interface inter = retrofit.create(Interface.class);

        Call<MSG<RetornoValidacao>> call = inter.validacao(
                                                this.CV,
                                                "Validacao",
                                                    parametros);

        Retorno<RetornoValidacao> retorno = new Retorno<RetornoValidacao>(tela){

            @Override
            public void retorno(Response<MSG<RetornoValidacao>> response) {

                int cont = response.body().getValores() != null ? response.body().getValores().size() : 0;

                if(cont>0) {

                    RetornoValidacao aux = response.body().getValores().get(0);

                    new PreparadorDeValores<RetornoValidacao>().preparaValores(RetornoValidacao.class, aux);

                    Item item = new Item();
                    item.setParam_t(aux);
                    tela.retorno(item);

                    return;
                }

                tela.retorno(null);
            }

            public void emCasoDeErro(){

                tela.retorno(null);
            }
        };

        call.enqueue(retorno);

        return;
    }


}