package com.ilxbrasil.ingressos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ilxbrasil.ingressos.componentes.Tela;


/**
 * Created by fl4v10 on 12/10/2017.
 */

public class Tela_Sobre extends Tela{


    private Tela tela;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_sobre);

        this.tela = this;

        ((TextView) findViewById(R.id.nome)).setText(getString(R.string.app_name));
        ((TextView) findViewById(R.id.versao)).setText(getString(R.string.versao_nome)+" ("+getString(R.string.versao_cod)+".0)");
        ((TextView) findViewById(R.id.email)).setText(getString(R.string.app_email));
        ((TextView) findViewById(R.id.site)).setText(getString(R.string.app_site));



        ((Button) findViewById(R.id.bt_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }
        });

    }




}