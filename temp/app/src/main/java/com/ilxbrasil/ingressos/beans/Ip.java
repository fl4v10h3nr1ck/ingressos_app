package com.ilxbrasil.ingressos.beans;

import com.ilxbrasil.ingressos.DAO.anotacoes.Campo;
import com.ilxbrasil.ingressos.DAO.anotacoes.Tabela;

/**
 * Created by fl4v10 on 04/12/2016.
 */

@Tabela(nome="ip_servidor", prefixo="ip")
public class Ip {


    @Campo(nome = "id", Inteiro = true, set = "setId", get = "getId", Id=true)
    private int id;

    @Campo(nome = "ip", set = "setIp", get = "getIp")
    private String ip;




    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public String getIp() {
        return ip;
    }
    public void setIp(String ip) {
        this.ip = ip;
    }
}