package com.ilxbrasil.ingressos.componentes;


import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;


public class CampoCPF extends AppCompatEditText {

        private boolean isUpdating;


        private int positioning[] = { 0, 1, 2, 4, 5, 6, 8, 9, 10, 12, 13, 14};


        public CampoCPF(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
            initialize();

        }

        public CampoCPF(Context context, AttributeSet attrs) {
            super(context, attrs);
            initialize();

        }

        public CampoCPF(Context context) {
            super(context);
            initialize();

        }

        public String getCleanText() {
            String text = CampoCPF.this.getText().toString();

            text.replaceAll("[^0-9]*", "");
            return text;

        }



        private void initialize() {

            final int maxNumberLength = 11;
            this.setKeyListener(keylistenerNumber);

            this.setText("   .   .   -  ");
            this.setSelection(1);

            this.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable s) {
                    String current = s.toString();

                    if (isUpdating) {
                        isUpdating = false;
                        return;

                    }

                    String number = current.replaceAll("[^0-9]*", "");
                    if (number.length() > maxNumberLength)
                        number = number.substring(0, maxNumberLength);

                    int length = number.length();

                    String part1;
                    String part2 = "";
                    String part3 = "";
                    String part4 = "";

                    if(length<3)
                        part1 = number.substring(0);
                    else{

                        part1 = number.substring(0, 3);

                        if(length<6)
                            part2 = number.substring(3);
                        else {

                            part2 = number.substring(3, 6);

                            if(length<9)
                                part3 = number.substring(6);
                            else {

                                part3 = number.substring(6, 9);

                                if (length >= 9)
                                    part4 = number.substring(9);
                            }
                        }
                    }



                    String phone = part1+"." + part2 + "." + part3 + "-" + part4;

                    isUpdating = true;
                    CampoCPF.this.setText(phone);

                    CampoCPF.this.setSelection(positioning[length]);
                }

                public void beforeTextChanged(CharSequence s, int start, int count,
                                              int after) {

                }

                public void onTextChanged(CharSequence s, int start, int before,
                                          int count) {

                }
            });
        }

        protected String padNumber(String number, int maxLength) {
            String padded = new String(number);
            for (int i = 0; i < maxLength - number.length(); i++)
                padded += " ";
            return padded;

        }

        private final KeylistenerNumber keylistenerNumber = new KeylistenerNumber();

        private class KeylistenerNumber extends NumberKeyListener {

            public int getInputType() {
                return InputType.TYPE_CLASS_NUMBER
                        | InputType.TYPE_TEXT_FLAG_NO_SUGGESTIONS;

            }

            @Override
            protected char[] getAcceptedChars() {
                return new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };

            }
        }
    }