package com.ilxbrasil.ingressos.beans;

import com.ilxbrasil.ingressos.DAO.anotacoes.Campo;
import com.ilxbrasil.ingressos.DAO.anotacoes.Tabela;

import java.util.List;

/**
 * Created by fl4v10 on 04/12/2016.
 */

@Tabela(nome="Usuario", prefixo="usr")
public class Usuario {


    @Campo(nome = "id", Inteiro = true, set = "setId", get = "getId", Id=true)
    private int id;

    @Campo(nome = "id_remoto", Inteiro = true, set = "setId_remoto", get = "getId_remoto")
    private int id_remoto;

    @Campo(nome = "nome", set = "setNome", get = "getNome")
    private String nome;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public int getId_remoto() {
        return id_remoto;
    }
    public void setId_remoto(int id_remoto) {
        this.id_remoto = id_remoto;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
}