package com.ilxbrasil.ingressos.componentes;


import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.ilxbrasil.ingressos.R;


/**
 * Created by fl4v10 on 02/12/2016.
 */

public abstract class TelaComMenu<T> extends Tela<T> {


    public Toolbar toolbar;

    public static NavigationView navigationView;

    public DrawerLayout drawerLayout;





    public void setMenu(){

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.nav_view);

        if(navigationView!=null) {

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(MenuItem menuItem) {


                    drawerLayout.closeDrawers();

                    return abreItemDeMenu(menuItem.getItemId());
                }
            });

            drawerLayout = (DrawerLayout) findViewById(R.id.tl_drawerlayout);
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
    }






    public void setCabecalho(){

        if(navigationView!=null) {

            Menu nv = navigationView.getMenu();

            View header = navigationView.getHeaderView(0);
/*
            if(Comuns.usuarioAtual!=null) {

                header.findViewById(R.id.cmp_menu_cab_area_dados_taxista).setVisibility(View.VISIBLE);
                header.findViewById(R.id.cmp_menu_cab_area_dados_cliente).setVisibility(View.GONE);

                ((TextView) header.findViewById(R.id.cmp_menu_cab_nome_user)).setText(Comuns.usuarioAtual.getNome());

                if(Comuns.usuarioAtual.getAssistente()>0)
                    header.findViewById(R.id.cmp_menu_cab_nome_assistente).setVisibility(View.VISIBLE);
                else
                    header.findViewById(R.id.cmp_menu_cab_nome_assistente).setVisibility(View.INVISIBLE);

                if (Comuns.usuarioAtual.getAvaliacao() >= 1)
                    ((ImageView) header.findViewById(R.id.cmp_menu_cab_avalia_1)).setImageResource(R.drawable.estrela_2);

                if (Comuns.usuarioAtual.getAvaliacao() >= 2)
                    ((ImageView) header.findViewById(R.id.cmp_menu_cab_avalia_2)).setImageResource(R.drawable.estrela_2);

                if (Comuns.usuarioAtual.getAvaliacao() >= 3)
                    ((ImageView) header.findViewById(R.id.cmp_menu_cab_avalia_3)).setImageResource(R.drawable.estrela_2);

                if (Comuns.usuarioAtual.getAvaliacao() >= 4)
                    ((ImageView) header.findViewById(R.id.cmp_menu_cab_avalia_4)).setImageResource(R.drawable.estrela_2);

                if (Comuns.usuarioAtual.getAvaliacao() >= 5)
                    ((ImageView) header.findViewById(R.id.cmp_menu_cab_avalia_5)).setImageResource(R.drawable.estrela_2);

                SimpleDraweeView img =(SimpleDraweeView) header.findViewById(R.id.cmp_menu_cab_foto);

                if(Comuns.temConteudo(Comuns.usuarioAtual.getImg_profile()))
                    Comuns.setCarregamentoDeImagem(img, Servidor.LOCAL_IMG_FOTO_TAXISTA+Comuns.usuarioAtual.getImg_profile(), Comuns.TAM_PADRAO_IMG, Comuns.TAM_PADRAO_IMG);
                else
                    Comuns.setCarregamentoDeImagem(img,
                            R.drawable.icon_menu_perfil, Comuns.TAM_PADRAO_IMG, Comuns.TAM_PADRAO_IMG);

                img.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        processa_logo  =true;
                        buscaImagem();
                    }
                });
            }
            else{

                header.findViewById(R.id.cmp_menu_cab_area_dados_taxista).setVisibility(View.GONE);
                header.findViewById(R.id.cmp_menu_cab_area_dados_cliente).setVisibility(View.VISIBLE);
            }


            if(Comuns.usuarioAtual!=null) {
                nv.findItem(R.id.item_menu_entrar).setVisible(false);
                nv.findItem(R.id.item_trocar_senha).setVisible(true);
                nv.findItem(R.id.item_menu_chat).setVisible(true);
            }
            else {
                nv.findItem(R.id.item_menu_sair).setVisible(false);
                nv.findItem(R.id.item_trocar_senha).setVisible(false);
                nv.findItem(R.id.item_menu_chat).setVisible(false);
            }*/
        }
    }





    public abstract boolean abreItemDeMenu(int id_item);








}
