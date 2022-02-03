package com.ilxbrasil.ingressos.util;


import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;

import com.ilxbrasil.ingressos.componentes.Tela;


/**
 * Created by fl4v10 on 06/10/2016.
 */



public class Permissao{


    public static final int PERMISSAO_PARA_ARQUIVO= 17;
    public static final int PERMISSAO_PARA_CAMERA= 27;
    public static final int PERMISSAO_PARA_LOCALIZACAO= 57;
    public static final int PERMISSAO_PARA_NOTIFICACAO= 67;

    public int ult_permissao_solicitada;






    public Permissao(){

        this.ult_permissao_solicitada = 0;
    }





    public boolean temPermissao(Context tela, int tipo_permissao){

        boolean permissao = true;

        if (Build.VERSION.SDK_INT >= 23) {

            if(tipo_permissao == PERMISSAO_PARA_ARQUIVO) {

                if (tela.checkSelfPermission("android.permission.READ_EXTERNAL_STORAGE")
                        != PackageManager.PERMISSION_GRANTED)
                    permissao = false;
            }

            if(tipo_permissao == PERMISSAO_PARA_CAMERA) {

                if (tela.checkSelfPermission("android.permission.CAMERA")
                        != PackageManager.PERMISSION_GRANTED)
                    permissao = false;
            }

            if(tipo_permissao == PERMISSAO_PARA_LOCALIZACAO) {

                if (tela.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION")
                        != PackageManager.PERMISSION_GRANTED)
                    permissao = false;
            }

            if(tipo_permissao == PERMISSAO_PARA_NOTIFICACAO) {

                if (tela.checkSelfPermission("android.permission.BIND_NOTIFICATION_LISTENER_SERVICE")
                        != PackageManager.PERMISSION_GRANTED)
                    permissao = false;
            }
        }

        return permissao;
    }






    public void solicitaPermissao(Tela tela, int tipo_permissao){

        this.ult_permissao_solicitada = 0;

        if (Build.VERSION.SDK_INT >= 23) {

            String[] permissoes = null;

            if(tipo_permissao == PERMISSAO_PARA_ARQUIVO) {
                permissoes = new String[]{Manifest.permission.READ_EXTERNAL_STORAGE};
                this.ult_permissao_solicitada = PERMISSAO_PARA_ARQUIVO;
            }
            else if(tipo_permissao == PERMISSAO_PARA_CAMERA) {
                permissoes = new String[]{Manifest.permission.CAMERA};
                this.ult_permissao_solicitada = PERMISSAO_PARA_CAMERA;
            }
            else if(tipo_permissao == PERMISSAO_PARA_LOCALIZACAO) {
                permissoes = new String[]{Manifest.permission.ACCESS_FINE_LOCATION};
                this.ult_permissao_solicitada = PERMISSAO_PARA_LOCALIZACAO;
            }
            else if(tipo_permissao == PERMISSAO_PARA_NOTIFICACAO) {
                permissoes = new String[]{Manifest.permission.BIND_NOTIFICATION_LISTENER_SERVICE};
                this.ult_permissao_solicitada = PERMISSAO_PARA_NOTIFICACAO;
            }

            if(permissoes!=null && permissoes.length>0)
                tela.requestPermissions(permissoes, this.ult_permissao_solicitada);
        }
    }




}