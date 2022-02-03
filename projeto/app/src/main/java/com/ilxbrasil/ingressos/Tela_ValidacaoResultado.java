package com.ilxbrasil.ingressos;


import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ilxbrasil.ingressos.beans.RetornoValidacao;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.util.Comuns;
import com.ilxbrasil.ingressos.util.Data;


public class Tela_ValidacaoResultado extends Tela {


    private RetornoValidacao retorno;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_resultado_validacao);

        Button bt_fechar = (Button) findViewById(R.id.tl_rvl_fechar);
        bt_fechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               finish();
            }
        });

        retorno = (RetornoValidacao)getIntent().getSerializableExtra("resultado");

        if(retorno==null){

            ((TextView) findViewById(R.id.tl_rvl_resultado)).setText("INGRESSO INVÁLIDO!");
            ((TextView) findViewById(R.id.tl_rvl_codigo)).setText("Este código não corresponde a nenhum ingresso.");
            findViewById(R.id.tl_rvl_data).setVisibility(View.GONE);
            findViewById(R.id.tl_rvl_lote_cod).setVisibility(View.GONE);
            findViewById(R.id.tl_rvl_lote_preco).setVisibility(View.GONE);
            findViewById(R.id.tl_rvl_lote_tipo).setVisibility(View.GONE);
            findViewById(R.id.tl_rvl_evt_data).setVisibility(View.GONE);
            findViewById(R.id.tl_rvl_evt_nome).setVisibility(View.GONE);

            ((TextView) findViewById(R.id.tl_rvl_resultado)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
            ((TextView) findViewById(R.id.tl_rvl_codigo)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
        }
        else{

            if(retorno.getUsado()<=0) {

                ((TextView) findViewById(R.id.tl_rvl_resultado)).setText("INGRESSO VÁLIDO!");
                ((TextView) findViewById(R.id.tl_rvl_codigo)).setText("Código do Ingresso: "+(Comuns.temConteudo(retorno.getCodigo())?retorno.getCodigo():"indifinido"));
                findViewById(R.id.tl_rvl_data).setVisibility(View.GONE);
                ((TextView) findViewById(R.id.tl_rvl_lote_cod)).setText("Lote: "+retorno.getLote_cod());
                ((TextView) findViewById(R.id.tl_rvl_lote_preco)).setText("Preço: "+retorno.getLote_preco());
                ((TextView) findViewById(R.id.tl_rvl_lote_tipo)).setText("Tipo: "+retorno.getLote_tipo());
                ((TextView) findViewById(R.id.tl_rvl_evt_data)).setText("Evento: "+retorno.getEvento_nome());
                ((TextView) findViewById(R.id.tl_rvl_evt_nome)).setText("Data: "+Data.converteEUAParaBR(retorno.getEvento_data())+" "+retorno.getEvento_hora_inicio()+" às "+retorno.getEvento_hora_fim());

                ((TextView) findViewById(R.id.tl_rvl_resultado)).setTextColor(ContextCompat.getColor(this, R.color.verde));
                ((TextView) findViewById(R.id.tl_rvl_codigo)).setTextColor(ContextCompat.getColor(this, R.color.verde));
            }
            else{

                ((TextView) findViewById(R.id.tl_rvl_resultado)).setText("INGRESSO JÁ FOI USADO E VALIDADO!");
                ((TextView) findViewById(R.id.tl_rvl_codigo)).setText("Código do Ingresso: "+(Comuns.temConteudo(retorno.getCodigo())?retorno.getCodigo():"indifinido"));
                ((TextView) findViewById(R.id.tl_rvl_data)).setText("Usado e validado em: "+ Data.converteEUAParaBR(retorno.getData_usado())+" "+retorno.getHora_usado()+":"+retorno.getMin_usado());
                ((TextView) findViewById(R.id.tl_rvl_lote_cod)).setText("Este ingresso não é mais válido.");

                findViewById(R.id.tl_rvl_lote_preco).setVisibility(View.GONE);
                findViewById(R.id.tl_rvl_lote_tipo).setVisibility(View.GONE);
                findViewById(R.id.tl_rvl_evt_data).setVisibility(View.GONE);
                findViewById(R.id.tl_rvl_evt_nome).setVisibility(View.GONE);

                ((TextView) findViewById(R.id.tl_rvl_resultado)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
                ((TextView) findViewById(R.id.tl_rvl_codigo)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
                ((TextView) findViewById(R.id.tl_rvl_data)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
                ((TextView) findViewById(R.id.tl_rvl_lote_cod)).setTextColor(ContextCompat.getColor(this, R.color.vermelho));
            }
        }
    }








}