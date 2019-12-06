package com.pabloes99.commonbeats.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.pabloes99.commonbeats.R;
import com.pabloes99.commonbeats.utils.CommonUtils;

public class RegistroActivity extends AppCompatActivity {
    private Button btSignUp;
    private TextInputEditText tiedUser;
    private TextInputEditText tiedPassword;
    private TextInputEditText tiedEmail;

    private TextInputLayout tilUser;
    private TextInputLayout tilPassword1;
    private TextInputLayout tilEmail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        // Se recoge todos los InputLayout
        tilUser = findViewById(R.id.tilUser);
        tilPassword1 = findViewById(R.id.tilPassword);
        tilEmail = findViewById(R.id.tilEmail);



        // Se recoge todas las cadenas introducidas por el usuario
        btSignUp = findViewById(R.id.btSignUp);
        tiedUser = findViewById(R.id.tiedUser);
        tiedPassword = findViewById(R.id.tiedPassword);
        tiedEmail = findViewById(R.id.tiedEmail);


        tiedUser.addTextChangedListener(new SignUpWatcher(tiedUser));
        tiedPassword.addTextChangedListener(new SignUpWatcher(tiedPassword));
        tiedEmail.addTextChangedListener(new SignUpWatcher(tiedEmail));

        btSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate();
            }
        });
    }

    /***
     * Método que compureba la validez de los campos TextInputLayout
     */
    private void validate() {
        if (validateUser(tiedUser.getText().toString()) && validatePassword(tiedPassword.getText().toString()) && validateEmail(tiedEmail.getText().toString())){
            //1. Se guardaría el usuario en la BD
            //2. Envio correo de confirmación al usuario (Firebase).
            //3. Se pasa a la ventana Login
            finish();
        }
    }

    /***
     * Este método valida el usuario:
     * 1. No puede ser nulo
     * @return
     */
    private boolean validateUser(String user) {
        if (TextUtils.isEmpty(user))
        {
            tilUser.setError(getString(R.string.errUserEmpty));
            displaySoftKeyboard(tiedUser);
            return false;
        }
        else{
            tilUser.setError(null);
            return true;
        }
    }




    /***
     * Este método valida las contraseñas:
     * 1. El tamaño es ocho, una mayúscula y un número
     * 2. No puede ser nulo
     * @return
     */
    private boolean validatePassword(String password1) {
        if (CommonUtils.checkPatternPassword(password1)) {
            tilPassword1.setError(null);
            return true;
        }
        tilPassword1.setError(getString(R.string.errPasswordWrong));
        displaySoftKeyboard(tiedPassword);
        return false;
    }

    /***
     * Este método valida que el email:
     * 1. No puede ser nulo
     * @param email
     * @return
     */
    private boolean validateEmail(String email) {
        if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            tilEmail.setError(null);
            return true;
        }
        tilEmail.setError(getString(R.string.errEmailWrong));
        displaySoftKeyboard(tiedEmail);
        return false;
    }

    class SignUpWatcher implements TextWatcher
    {
        private View view;
        private SignUpWatcher (View view){
            this.view = view;
        }

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            switch (view.getId()){
                case R.id.tiedUser:{
                    validateUser(((TextInputEditText) view).getText().toString());
                    break;
                }
                case R.id.tiedPassword:{
                    validatePassword(((TextInputEditText) view).getText().toString());
                    break;
                }
                case R.id.tiedEmail:{
                    validateEmail(((TextInputEditText) view).getText().toString());
                    break;
                }
            }
        }
    }

    /**
     * Este método abre el teclado en el caso que una vista tenga el foco (TextInputEditText) tenga el foco
     * @param view
     */
    private void displaySoftKeyboard(View view) {
        if (view.requestFocus()){
            ((InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE)).showSoftInput(view, 0);
        }
    }
}
