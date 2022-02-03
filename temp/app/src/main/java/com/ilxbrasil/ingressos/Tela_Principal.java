package com.ilxbrasil.ingressos;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;




import com.ilxbrasil.ingressos.componentes.Tela;

public class Tela_Principal extends Tela {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.tl_principal);

/*
        Button bt_capturar = findViewById(R.id.tl_capturar);
        bt_capturar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Intent it = new Intent(Tela_Principal.this, zxing.google.zxing.client.android.CaptureActivity.class);
               // startActivityForResult(it, 1);
            }
        });*/
    }




    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if(1 == requestCode && RESULT_OK == resultCode){
            Log.i("RESULTADO:", data.getStringExtra("SCAN_RESULT")+" ("+data.getStringExtra("SCAN_FORMAT")+")");
        }
    }





}
