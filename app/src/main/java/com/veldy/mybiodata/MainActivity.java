package com.veldy.mybiodata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.LocusId;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.nio.channels.InterruptedByTimeoutException;

public class MainActivity extends AppCompatActivity {

    private Utilities utilities = new Utilities();
    private TextView tvUsername;
    private Button btnLogout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvUsername = findViewById(R.id.tv_username);
        btnLogout = findViewById(R.id.btn_logout);
        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                utilities.setpref(MainActivity.this, "xUsername", null);
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });


        if(!utilities.isLogin(this,"xUsername")){
            Intent intent = new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else{
            String username = utilities.getPref(this,"xUsername");
            tvUsername.setText(username);
        }
    }
}