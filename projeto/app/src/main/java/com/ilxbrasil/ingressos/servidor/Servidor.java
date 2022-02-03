package com.ilxbrasil.ingressos.servidor;


import android.util.Log;

import com.ilxbrasil.ingressos.util.Comuns;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Set;

import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.Retrofit;



/**
 * Created by fl4v10 on 03/10/2016.
 */

public class Servidor {


    public final static int VERSAO_SERVIDOR= 1;

    protected static final String CV =      VERSAO_SERVIDOR+"@7b4zA40HNdo10RgTpGm2ft1QatRRlL0uZ20AcHgGgK18swUx";

    public final static String SEPARADOR1= "@_@";

    public final static String SEPARADOR2= "#_#";

    /*******************************************************************************************************/


    public final static String PATH = "ingresso/projeto/servidor/";


    /*******************************************************************************************************/


    //public final static String URL = URL_BASE+"servidor/";



    /*******************************************************************************************************/


    protected Retrofit retrofit;




    public Servidor(){

        this.retrofit = new Retrofit.Builder()
                .baseUrl(getLocal())
                .addConverterFactory(GsonConverterFactory.create()) .build();
    }



    private String preparaStringParaEnviar(String valor){

        if(valor==null || valor.length()==0)
            return "";

        valor = valor.replace("\"", "_as2_");
        valor = valor.replace("'", "_as1_");
        valor = valor.replace("&", "_ec_");
        valor = valor.replace("=", "_iq_");
        valor = valor.replace(" ", "_es_");
        valor = valor.replace("\n", "_bb_");


        valor = valor.replace("á", "_a1_");
        valor = valor.replace("â", "_a2_");
        valor = valor.replace("à", "_a3_");
        valor = valor.replace("ã", "_a4_");
        valor = valor.replace("é", "_e1_");
        valor = valor.replace("ê", "_e2_");
        valor = valor.replace("í", "_i1_");
        valor = valor.replace("ó", "_o1_");
        valor = valor.replace("ô", "_o2_");
        valor = valor.replace("õ", "_o3_");
        valor = valor.replace("ú", "_u1_");
        valor = valor.replace("ç", "_c1_");



        valor = valor.replace("Á", "_A1_");
        valor = valor.replace("Â", "_A2_");
        valor = valor.replace("À", "_A3_");
        valor = valor.replace("Ã", "_A4_");
        valor = valor.replace("É", "_E1_");
        valor = valor.replace("Ê", "_E2_");
        valor = valor.replace("Í", "_I1_");
        valor = valor.replace("Ó", "_O1_");
        valor = valor.replace("Ô", "_O2_");
        valor = valor.replace("Õ", "_O3_");
        valor = valor.replace("Ú", "_U1_");
        valor = valor.replace("Ç", "_C1_");

        return valor;
    }





    protected String preparaStringParaReceber(String valor){

        if(valor==null || valor.length()==0)
            return "";

        valor = valor.replace("_as2_", "\"");
        valor = valor.replace("_as1_", "'");
        valor = valor.replace("_vel_", "#");
        valor = valor.replace("_ec_", "&");
        valor = valor.replace("_iq_", "=");
        valor = valor.replace("_es_", " ");
        valor = valor.replace("_bb_", "\n");

        valor = valor.replace("_a1_", "á");
        valor = valor.replace("_a2_", "â");
        valor = valor.replace("_a3_", "à");
        valor = valor.replace("_a4_", "ã");
        valor = valor.replace("_e1_", "é");
        valor = valor.replace("_e2_", "ê");
        valor = valor.replace("_i1_", "í");
        valor = valor.replace("_o1_", "ó");
        valor = valor.replace("_o2_", "ô");
        valor = valor.replace("_o3_", "õ");
        valor = valor.replace("_u1_", "ú");
        valor = valor.replace("_c1_", "ç");


        valor = valor.replace("_A1_", "Á");
        valor = valor.replace("_A2_", "Â");
        valor = valor.replace("_A3_", "À");
        valor = valor.replace("_A4_", "Ã");
        valor = valor.replace("_E1_", "É");
        valor = valor.replace("_E2_", "Ê");
        valor = valor.replace("_I1_", "Í");
        valor = valor.replace("_O1_", "Ó");
        valor = valor.replace("_O2_", "Ô");
        valor = valor.replace("_O3_", "Õ");
        valor = valor.replace("_U1_", "Ú");
        valor = valor.replace("_C1_", "Ç");

        return valor;
    }




    protected String formaParametro(Map<String, String> valores){

        if(valores==null || valores.size()==0)
            return"{}";

        StringBuilder parametros = new StringBuilder("{");

        Set<String> chaves = valores.keySet();

        for (String chave : chaves){
            if(chave != null && chave.length()>0) {
                String val = valores.get(chave);
                parametros.append("\"" + chave + "\":\"" + (val == null ? "" :preparaStringParaEnviar(val.trim())) + "\",");
            }
        }

        if(parametros.charAt(parametros.length()-1)==',')
            return parametros.substring(0, parametros.length()-1)+"}";

        return parametros.toString()+"}";
    }




    protected class PreparadorDeValores<T> {


        public void preparaValores(Class<?> tipo, T classe) {

            try {
                for (Field campo : tipo.getDeclaredFields()) {

                    if (campo.getType() == String.class) {

                        String nome = campo.getName().substring(0,1).toUpperCase()+campo.getName().substring(1);
                        tipo.getDeclaredMethod("set"+nome, String.class).invoke(classe,
                                preparaStringParaReceber((String)(tipo.getDeclaredMethod("get"+nome).invoke(classe))));
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
                return;
            }
        }



        public void preparaValores(Class<?> tipo, List<T> classes) {

            for(T classe: classes)
                preparaValores(tipo, classe);

        }


    }




    public static String stringSemAcentuacao(String valor){

        if(valor==null || valor.length()==0)
            return "";

        valor = valor.replace("á", "a");
        valor = valor.replace("â", "a");
        valor = valor.replace("à", "a");
        valor = valor.replace("ã", "a");
        valor = valor.replace("é", "e");
        valor = valor.replace("ê", "e");
        valor = valor.replace("í", "i");
        valor = valor.replace("ó", "o");
        valor = valor.replace("ô", "o");
        valor = valor.replace("õ", "o");
        valor = valor.replace("ú", "u");
        valor = valor.replace("ç", "c");

        valor = valor.replace("Á", "A");
        valor = valor.replace("Â", "A");
        valor = valor.replace("À", "A");
        valor = valor.replace("Ã", "A");
        valor = valor.replace("É", "E");
        valor = valor.replace("Ê", "E");
        valor = valor.replace("Í", "I");
        valor = valor.replace("Ó", "O");
        valor = valor.replace("Ô", "O");
        valor = valor.replace("Õ", "O");
        valor = valor.replace("Ú", "U");
        valor = valor.replace("Ç", "C");

        return valor;
    }




    private String getLocal(){

        if(Comuns.ip_servidor!=null)
            return "http://"+Comuns.ip_servidor.getIp()+"/"+PATH;

        return null;
    }

}


