package com.ilxbrasil.ingressos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.SwitchCompat;
import android.text.Html;
import android.view.LayoutInflater;

import android.view.Menu;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ilxbrasil.ingressos.componentes.TelaComMenu;
import com.ilxbrasil.ingressos.util.Comuns;


public class Tela_Base<T> extends TelaComMenu<T> {

    private TabLayout tabLayout;

    public FragmentStatePagerAdapter mSectionsPagerAdapter;

    private ViewPager mViewPager;

    public LayoutInflater inflater;

    private boolean mudando_status_de_taxista;





    public Tela_Base(){

        super();
    }





    public void onResume(){

        super.onResume();

        Comuns.telaAtual = this;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        this.mudando_status_de_taxista = false;
    }



    protected void configura(int id_conteudo) {configura(id_conteudo, null);}



    protected void configura(FragmentStatePagerAdapter adapter) {configura(0, adapter);}



    protected void configura(int id_conteudo, FragmentStatePagerAdapter adapter) {

        this.setMenu();


        this.mSectionsPagerAdapter = adapter;

        if(adapter!=null) {


            findViewById(R.id.conteudo).setVisibility(View.GONE);
            findViewById(R.id.pagina).setVisibility(View.VISIBLE);

            mViewPager = (ViewPager) findViewById(R.id.pagina);
            mViewPager.setAdapter(mSectionsPagerAdapter);

            //findViewById(R.id.tabs).setVisibility(View.VISIBLE);

           // this.tabLayout = (TabLayout) findViewById(R.id.tabs);
           // this.tabLayout.setupWithViewPager(mViewPager);
        }
        else {

            findViewById(R.id.conteudo).setVisibility(View.VISIBLE);
            //findViewById(R.id.tabs).setVisibility(View.GONE);
            findViewById(R.id.pagina).setVisibility(View.GONE);

           // LinearLayout area_conteudo = this.findViewById(R.id.conteudo);
            //area_conteudo.removeAllViews();

           // this.inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            //area_conteudo.addView(inflater.inflate(id_conteudo, area_conteudo, false));
        }

        setCabecalho();
    }



    @Override
    public boolean abreItemDeMenu(int id_item){

        Intent i;
/*
        switch (id_item) {

            case R.id.item_menu_inicio:

                if(Comuns.usuarioAtual==null)
                    i = new Intent(tela, TelaPrincipalCliente.class);
                else
                    i = new Intent(tela, TelaPrincipalTaxista.class);

                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                tela.startActivity(i);
                return true;

            case R.id.item_menu_chat:

                i = new Intent(tela, TelaChatComOperador.class);
                tela.startActivity(i);
                return true;

            case R.id.item_menu_entrar:

                i = new Intent(tela, TelaLogin.class);
                startActivity(i);
                return true;

            case R.id.item_menu_sair:

                desconectando = true;
                iniciaCarregamento("Desconectando...");
                return true;

            case R.id.item_menu_sobre:

                i = new Intent(tela, TelaSobre.class);
                startActivity(i);
                return true;

            case R.id.item_trocar_senha:

                i = new Intent(tela, TelaTrocaSenha.class);
                tela.startActivity(i);
                return true;
        }
*/
        return true;
    }







}