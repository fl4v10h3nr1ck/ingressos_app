package com.ilxbrasil.ingressos.beans;

import java.io.Serializable;

/**
 * Created by fl4v10 on 04/12/2016.
 */


public class RetornoValidacao implements Serializable{


    private String codigo;
    private int usado;
    private String lote_cod;
    private String lote_preco;
    private String lote_tipo;
    private String evento_data;
    private int evento_hora_inicio;
    private int evento_hora_fim;
    private String evento_nome;
    private String data_usado;
    private int hora_usado;
    private int min_usado;


    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getUsado() {
        return usado;
    }
    public void setUsado(int usado) {
        this.usado = usado;
    }

    public String getLote_cod() {
        return lote_cod;
    }
    public void setLote_cod(String lote_cod) {
        this.lote_cod = lote_cod;
    }

    public String getLote_preco() {
        return lote_preco;
    }
    public void setLote_preco(String lote_preco) {
        this.lote_preco = lote_preco;
    }

    public String getLote_tipo() {
        return lote_tipo;
    }
    public void setLote_tipo(String lote_tipo) {
        this.lote_tipo = lote_tipo;
    }

    public String getEvento_data() {
        return evento_data;
    }
    public void setEvento_data(String evento_data) {
        this.evento_data = evento_data;
    }

    public int getEvento_hora_inicio() {
        return evento_hora_inicio;
    }
    public void setEvento_hora_inicio(int evento_hora_inicio) {
        this.evento_hora_inicio = evento_hora_inicio;
    }

    public int getEvento_hora_fim() {
        return evento_hora_fim;
    }
    public void setEvento_hora_fim(int evento_hora_fim) {
        this.evento_hora_fim = evento_hora_fim;
    }

    public String getEvento_nome() {
        return evento_nome;
    }
    public void setEvento_nome(String evento_nome) {
        this.evento_nome = evento_nome;
    }

    public String getData_usado() {
        return data_usado;
    }
    public void setData_usado(String data_usado) {
        this.data_usado = data_usado;
    }

    public int getHora_usado() {
        return hora_usado;
    }
    public void setHora_usado(int hora_usado) {
        this.hora_usado = hora_usado;
    }

    public int getMin_usado() {
        return min_usado;
    }
    public void setMin_usado(int min_usado) {
        this.min_usado = min_usado;
    }
}