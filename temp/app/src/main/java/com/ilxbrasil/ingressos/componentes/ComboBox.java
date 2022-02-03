package com.ilxbrasil.ingressos.componentes;

import android.content.Context;
import android.support.v7.widget.AppCompatSpinner;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;




/**
 * Created by fl4v10 on 07/07/2017.
 */

public class ComboBox extends AppCompatSpinner{


    //private int cor_texto;

    private Context contexto;

    private ProcessadorDeEventosDeCombo processadorDeEventosDeCombo;




    public ComboBox(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public ComboBox(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ComboBox(Context context) {
        super(context);
    }




    public void prepara(Context contexto) {

        prepara(contexto, null);
    }




/*
    public void prepara(Context contexto) {

        prepara(contexto, cor_do_texto, null);
    }

*/







    public void prepara(Context context, ProcessadorDeEventosDeCombo param){

        this.contexto = context;

        //this.cor_texto = cor_do_texto;

        this.processadorDeEventosDeCombo = param;

        /*
        if(this.cor_texto!=0)
        this.getBackground().setColorFilter(ContextCompat.getColor(contexto, cor_texto), PorterDuff.Mode.SRC_ATOP);
*/

        this.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                /*
                if (parent.getChildAt(0) != null && cor_texto!=0)
                    ((TextView) parent.getChildAt(0)).setTextColor(ContextCompat.getColor(contexto, cor_texto));
*/

                if(processadorDeEventosDeCombo !=null)
                processadorDeEventosDeCombo.aoMudarAEscolha();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }

        });
    }





    public void setDados(String[] valores){

        ArrayAdapter adapter =  new ArrayAdapter(contexto,android.R.layout.simple_spinner_item, valores);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        this.setAdapter(adapter);
    }





/*
    private class ArrayAdapterPerson extends ArrayAdapter<String> {



        public ArrayAdapterPerson(Context context, int id, String[] valores){
            super(context, id, valores);
        }



        @Override
        public View getDropDownView(int position, View convertView, ViewGroup parent) {

            View view = super.getView(position, convertView, parent);

            if(cor_texto!=0) {
                TextView text = (TextView) view.findViewById(android.R.id.text1);
                text.setTextColor(ContextCompat.getColor(getContext(), cor_texto));
                text.setPadding(10, 20, 10, 20);
            }

            return view;
        }
    }

*/



    public class ProcessadorDeEventosDeCombo {



        public void aoMudarAEscolha(){}


    }
}

