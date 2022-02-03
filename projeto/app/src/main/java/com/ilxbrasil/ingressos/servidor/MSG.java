package com.ilxbrasil.ingressos.servidor;

import java.util.List;

/**
 * Created by fl4v10 on 30/11/2016.
 */

public class MSG<T> {



    private String status;

    private String erro;

    private String msg;

    private List<T> valores;




    public String getStatus() {return status;}
    public void setStatus(String status) {this.status = status;}

    public String getErro() {return erro;}
    public void setErro(String erro) {this.erro = erro;}

    public String getMsg() {return msg;}
    public void setMsg(String msg) {this.msg = msg;}

    public List<T> getValores() {return valores;}
    public void setValores(List<T> valores) {this.valores = valores;}
}
