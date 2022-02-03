package com.ilxbrasil.ingressos.servidor;

import android.util.Log;


import com.ilxbrasil.ingressos.DAO.DAO;
import com.ilxbrasil.ingressos.beans.Item;
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

public class ServidorUsuario extends Servidor {




    public void logar(final Tela tela, String nome, String senha){


        Map<String, String> map= new HashMap<>();
        map.put("nome", nome);
        map.put("senha", senha);

        String parametros = formaParametro(map);

        if(Comuns.mostrarLog)
            Log.i("SERV_PARAM Logar", parametros);

        Interface inter = retrofit.create(Interface.class);

        Call<MSG<Usuario>> call = inter.logar(
                                                this.CV,
                                                "Logar",
                                                    parametros);

        Retorno<Usuario> retorno = new Retorno<Usuario>(tela){

            @Override
            public void retorno(Response<MSG<Usuario>> response) {

                int cont = response.body().getValores() != null ? response.body().getValores().size() : 0;

                if(cont>0) {

                    DAO<Usuario> dao = new DAO<Usuario>(Usuario.class, tela);

                    dao.remove("id>0");

                    Usuario aux = response.body().getValores().get(0);

                    new PreparadorDeValores<Usuario>().preparaValores(Usuario.class, aux);

                    int id = dao.novo(response.body().getValores().get(0));

                    Item item = new Item();
                    item.setParam_int(id);
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