package com.ilxbrasil.ingressos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.budiyev.android.codescanner.CodeScanner;
import com.budiyev.android.codescanner.CodeScannerView;
import com.budiyev.android.codescanner.DecodeCallback;
import com.google.zxing.Result;
import com.ilxbrasil.ingressos.beans.Item;
import com.ilxbrasil.ingressos.beans.RetornoValidacao;
import com.ilxbrasil.ingressos.componentes.Tela;
import com.ilxbrasil.ingressos.servidor.ServidorValidacao;
import com.ilxbrasil.ingressos.util.Comuns;


public class Tela_Principal extends Tela {


    public Toolbar toolbar;

    public static NavigationView navigationView;

    public DrawerLayout drawerLayout;

    private CodeScanner mCodeScanner;

    private ServidorValidacao servidor;

    private String codigo_temp;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_principal);

        toolbar = (Toolbar) findViewById(R.id.tl_pcp_toolbar);
        setSupportActionBar(toolbar);

        this.servidor = new ServidorValidacao();


        navigationView = (NavigationView) findViewById(R.id.nav_view);

        if(navigationView!=null) {

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {


                    drawerLayout.closeDrawers();

                    return abreItemDeMenu(menuItem.getItemId());
                }
            });

            drawerLayout = (DrawerLayout) findViewById(R.id.tl_pcp_drawerlayout);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(
                    this,
                    drawerLayout,
                    toolbar,
                    R.string.mn_it1,
                    R.string.mn_it2) {

                @Override
                public void onDrawerClosed(View drawerView) {

                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {

                    super.onDrawerOpened(drawerView);
                }
            };

            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            actionBarDrawerToggle.syncState();
        }


        CodeScannerView scannerView = findViewById(R.id.scanner_view);
        mCodeScanner = new CodeScanner(this, scannerView);
        mCodeScanner.setDecodeCallback(new DecodeCallback() {
            @Override
            public void onDecoded(@NonNull final Result result) {

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                       /* Toast.makeText(Tela_Principal.this, result.toString(), Toast.LENGTH_SHORT).show();*/

                       codigo_temp = result.toString();

                       iniciaCarregamento();
                    }
                });
            }
        });
        scannerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mCodeScanner.startPreview();
            }
        });
    }



    @Override
    protected void onResume() {

        super.onResume();

        mCodeScanner.startPreview();

        this.setCabecalho();
    }



    @Override
    protected void onPause() {

        mCodeScanner.releaseResources();

        super.onPause();
    }



    public boolean abreItemDeMenu(int id_item){

        Intent i;

        switch (id_item) {

            case R.id.item_menu_principal:

                i = new Intent(this, Tela_Principal.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;

            case R.id.item_menu_conectar:

                i = new Intent(this, Tela_Conecta.class);
                startActivity(i);
                return true;

            case R.id.item_menu_entrar:

                i = new Intent(this, Tela_Login.class);
                startActivity(i);
                return true;

            case R.id.item_menu_sair:

                Comuns.sair(this);
                i = new Intent(this, Tela_Abertura.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
                return true;

            case R.id.item_menu_sobre:

                i = new Intent(tela, Tela_Sobre.class);
                startActivity(i);
                return true;

            case R.id.item_menu_info_cod:

                i = new Intent(tela, Tela_InformaCodigo.class);
                startActivity(i);
                return true;
        }

        return true;
    }




    public void setCabecalho(){

        if(navigationView!=null) {

            Menu nv = navigationView.getMenu();

            View header = navigationView.getHeaderView(0);

            if(Comuns.usuarioAtual!=null) {

                MenuItem item = nv.findItem(R.id.item_menu_sair);

                if (item != null)
                    item.setVisible(true);

                item = nv.findItem(R.id.item_menu_entrar);

                if (item != null)
                    item.setVisible(false);

                if (header != null) {

                    header.findViewById(R.id.cmp_menu_cab_nome_user).setVisibility(View.VISIBLE);
                    ((TextView)header.findViewById(R.id.cmp_menu_cab_nome_user)).setText(Comuns.usuarioAtual.getNome());
                }
            }
            else{

                MenuItem item = nv.findItem(R.id.item_menu_sair);

                if (item != null)
                    item.setVisible(false);

                item = nv.findItem(R.id.item_menu_entrar);

                if (item != null)
                    item.setVisible(true);

                if (header != null) {

                    header.findViewById(R.id.cmp_menu_cab_nome_user).setVisibility(View.GONE);
                    ((TextView)header.findViewById(R.id.cmp_menu_cab_nome_user)).setText("");
                }
            }
        }
    }





    public void carregando(){

        servidor.valida(this, codigo_temp);
    }





    public void retorno(Item retorno) {

        desbloqueia();

        Intent i = new Intent(tela, Tela_ValidacaoResultado.class);
        i.putExtra("resultado", (RetornoValidacao)retorno.getParam_t());
        this.startActivity(i);
    }







}