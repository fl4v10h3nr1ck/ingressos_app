package com.ilxbrasil.ingressos.servidor;


import com.ilxbrasil.ingressos.beans.RetornoVazio;
import com.ilxbrasil.ingressos.beans.Usuario;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;

import retrofit2.http.POST;


/**
 * Created by fl4v10 on 29/09/2016.
 */


public interface Interface {


	/*_______________________________ usuarios _____________________________*/


    @FormUrlEncoded
    @POST( "index.php" )
    Call<MSG<Usuario>> logar(@Field("cv") String cv, @Field("tp") String tp, @Field("params") String param);

    @FormUrlEncoded
    @POST( "index.php" )
    Call<MSG<RetornoVazio>> testeDeConexao(@Field("cv") String cv, @Field("tp") String tp, @Field("params") String param);

}

