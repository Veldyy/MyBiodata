package com.veldy.mybiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText etUsername,etpassword;
    private Button btnLogin;
    private Utilities utilities = new Utilities();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUsername = findViewById(R.id.et_username);
        etpassword = findViewById(R.id.et_password);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                String username = etUsername.getText().toString();
                String password = etpassword.getText().toString();

                if(username.equals("admin") && password.equals("admin"))
                {
                    utilities.setpref(LoginActivity.this, "xUsername", username);
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                }
                else
                {
                    Toast.makeText(LoginActivity.this, "Login Gagal!!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}