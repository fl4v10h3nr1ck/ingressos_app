package com.ilxbrasil.ingressos.util;


import android.content.Context;

import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.util.DisplayMetrics;
import android.widget.Toast;


import com.ilxbrasil.ingressos.DAO.DAO;
import com.ilxbrasil.ingressos.Tela_Base;
import com.ilxbrasil.ingressos.beans.Ip;
import com.ilxbrasil.ingressos.beans.Usuario;
import com.ilxbrasil.ingressos.componentes.Tela;

import java.util.List;



/**
 * Created by fl4v10 on 03/10/2016.
 */

public class Comuns {


    public static SQLiteDatabase conexao;

    public static int tela_largura;
    public static int tela_altura;

    public static Tela_Base telaAtual;

    public static final boolean mostrarLog = true;

    public static final int TAM_PADRAO = 512;

    public static List<String> valores_temp;

    public static final int TAM_PADRAO_IMG = 512;

    public static Usuario usuarioAtual;

    public static Ip ip_servidor;
    //192.168.1.100




    public static void setValoresIniciais(Tela contexto) {

        if (contexto!=null) {

            usuarioAtual = new DAO<Usuario>(Usuario.class, contexto).getPrimeiroOuNada(null, null, null);

            ip_servidor = new DAO<Ip>(Ip.class, contexto).getPrimeiroOuNada(null, null, null);

        }
        else {
            usuarioAtual = null;
            ip_servidor = null;
        }
    }





    public static void sair(Tela contexto){

        new DAO<Usuario>(Usuario.class, contexto).remove("id>0");

        Comuns.setValoresIniciais(contexto);
    }





    public static void setDimensoes(Tela tela) {

        DisplayMetrics dm = new DisplayMetrics();
        tela.getWindowManager().getDefaultDisplay().getMetrics(dm);

        Comuns.tela_largura = dm.widthPixels;
        Comuns.tela_altura = dm.heightPixels;
    }





    public static void mensagem(Context contexto, String msg){

        if(msg==null || msg.length()==0 || contexto==null)
            return;

        Toast.makeText(contexto, msg, Toast.LENGTH_LONG).show();
    }





    public static boolean temConteudo(String valor) {

        return valor!=null && valor.length()>0;
    }



/*
    public static void setCarregamentoDeImagem(SimpleDraweeView img, String url){

        setCarregamentoDeImagem(img, url, 0, 0);
    }




    public static void setCarregamentoDeImagem(SimpleDraweeView img, String url, int largura, int altura){

        ImageRequestBuilder imageRequestBuilder = ImageRequestBuilder.newBuilderWithSource(Uri.parse(url));

        if(largura>0 && altura>0)
            imageRequestBuilder.setResizeOptions(new ResizeOptions(largura, altura));


        ImageRequest request = imageRequestBuilder.setProgressiveRenderingEnabled(true).
                setLocalThumbnailPreviewsEnabled(true)
                .build();

        AbstractDraweeController newController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setAutoPlayAnimations(true)
                .setOldController(img.getController())
                .build();

        img.setController(newController);
    }




    public static void setCarregamentoDeImagem(SimpleDraweeView img, int id, int largura, int altura){

        ImageRequest request = ImageRequestBuilder.newBuilderWithResourceId(id)
                .setResizeOptions(new ResizeOptions(largura, altura))
                .setProgressiveRenderingEnabled(true)
                .setLocalThumbnailPreviewsEnabled(true)
                .build();

        AbstractDraweeController newController = Fresco.newDraweeControllerBuilder()
                .setImageRequest(request)
                .setAutoPlayAnimations(true)
                .setOldController(img.getController())
                .build();

        img.setController(newController);
    }

*/


    public static String addPaddingAEsquerda(String valor, int num, String add){


        for(int i  = valor.length(); i < num; i++)
            valor = add+valor;

        return valor;
    }




    public static String removeUltimoSeparador(String valor, String separador) {

        if(separador ==null || separador.length()==0)
            return valor;

        if (valor.length() > 0) {

            if(valor.endsWith(separador)) {

                int posicao = valor.length() - separador.length();

                if(posicao==0)
                    return "";

                return valor.substring(0, posicao);
            }

            return valor;
        }

        return "";
    }




}
