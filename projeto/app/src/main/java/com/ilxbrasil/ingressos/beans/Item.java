package com.ilxbrasil.ingressos.beans;

import java.util.List;

/**
 * Created by fl4v10 on 04/12/2016.
 */


public class Item<T> {



    private boolean param_bol;

    private int param_int;

    private String param_string;

    private T param_t;

    private List<T> param_lista_t;

    private List<Integer> param_lista_int;

    private List<String> param_lista_string;




    public boolean isParam_bol() {
        return param_bol;
    }
    public void setParam_bol(boolean param_bol) {
        this.param_bol = param_bol;
    }

    public int getParam_int() {
        return param_int;
    }
    public void setParam_int(int param_int) {
        this.param_int = param_int;
    }

    public String getParam_string() {
        return param_string;
    }
    public void setParam_string(String param_string) {
        this.param_string = param_string;
    }

    public T getParam_t() {
        return param_t;
    }
    public void setParam_t(T param_t) {
        this.param_t = param_t;
    }

    public List<T> getParam_lista_t() {
        return param_lista_t;
    }
    public void setParam_lista_t(List<T> param_lista_t) {
        this.param_lista_t = param_lista_t;
    }

    public List<Integer> getParam_lista_int() {
        return param_lista_int;
    }
    public void setParam_lista_int(List<Integer> param_lista_int) {
        this.param_lista_int = param_lista_int;
    }

    public List<String> getParam_lista_string() {
        return param_lista_string;
    }
    public void setParam_lista_string(List<String> param_lista_string) {
        this.param_lista_string = param_lista_string;
    }


}