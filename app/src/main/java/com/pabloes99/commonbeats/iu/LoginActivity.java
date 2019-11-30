package com.pabloes99.commonbeats.iu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.pabloes99.commonbeats.R;

public class LoginActivity extends AppCompatActivity {

    private Button btnSignIn;
    private Button btnSignUp;
    private Button btnRecuperarContrasenna;
    private ImageButton ibtnRegistrarConGoogle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnRecuperarContrasenna = findViewById(R.id.btnRecuperarContrasenna);
        ibtnRegistrarConGoogle = findViewById(R.id.ibtnRegistrarConGoogle);
        btnSignIn = findViewById(R.id.btSignIn);
        btnSignUp = findViewById(R.id.btSignUp);

        btnSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent inten = new Intent(LoginActivity.this, DashBoardActivity.class);
                startActivity(inten);
            }
        });

        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        btnRecuperarContrasenna.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, R.string.btnRecuperarContrasennaToast, Toast.LENGTH_LONG).show();
            }
        });


        ibtnRegistrarConGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(LoginActivity.this, R.string.btnResgistrarseConGoogleToast, Toast.LENGTH_LONG).show();
            }
        });
    }

}
