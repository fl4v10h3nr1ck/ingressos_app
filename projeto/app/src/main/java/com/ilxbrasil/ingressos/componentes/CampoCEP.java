package com.ilxbrasil.ingressos.componentes;


import android.content.Context;
import android.support.v7.widget.AppCompatEditText;
import android.text.Editable;
import android.text.InputType;
import android.text.TextWatcher;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;





public class CampoCEP extends AppCompatEditText {

    private boolean isUpdating;


    private int positioning[] = { 0, 1, 2, 3, 4, 6, 7, 8, 9};

    public CampoCEP(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        initialize();

    }

    public CampoCEP(Context context, AttributeSet attrs) {
        super(context, attrs);
        initialize();

    }

    public CampoCEP(Context context) {
        super(context);
        initialize();

    }

    public String getCleanText() {
        String text = CampoCEP.this.getText().toString();

        text.replaceAll("[^0-9]*", "");
        return text;

    }

    private void initialize() {

        final int maxNumberLength = 8;
        this.setKeyListener(keylistenerNumber);

        this.setText("     -   ");
        this.setSelection(1);

        this.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable s) {
                String current = s.toString();

            /*
             * Ok, here is the trick... calling setText below will recurse
             * to this function, so we set a flag that we are actually
             * updating the text, so we don't need to reprocess it...
             */
                if (isUpdating) {
                    isUpdating = false;
                    return;

                }

            /* Strip any non numeric digit from the String... */
                String number = current.replaceAll("[^0-9]*", "");
                if (number.length() > 8)
                    number = number.substring(0, 8);

                int length = number.length();

                String p1;
                String p2;

                String paddedNumber = padNumber(number, maxNumberLength);

                p1 = paddedNumber.substring(0, 5);
                p2 = paddedNumber.substring(5);


            /* build the masked phone number... */
                String phone = p1+ "-" + p2;

            /*
             * Set the update flag, so the recurring call to
             * afterTextChanged won't do nothing...
             */
                isUpdating = true;
                CampoCEP.this.setText(phone);

                CampoCEP.this.setSelection(positioning[length]);

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
            return new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8','9' };

        }
    }
}