package com.a201381061.praktikumui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etUsername;
    EditText etPassword;
    Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        casting();
    }


    private void casting(){
        etUsername = (EditText)findViewById(R.id.username);
        etPassword = (EditText)findViewById(R.id.password);
        buttonLogin = (Button)findViewById(R.id.buttonLogin);
        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginUser();
            }
        });
    }

    private void loginUser(){
        String isiUsername = etUsername.getText().toString();
        String isPassword = etPassword.getText().toString();

        if(isiUsername.equals("ADMIN")&&isPassword.equals("12345")){
            //INI KETIKA USER BERHASIL LOGIN
            Toast.makeText(this,"Login Berhasil",Toast.LENGTH_SHORT).show();
        }else{
            //INI KETIKA USER GAGAL LOGIN

            Toast.makeText(this,"Login Gagal",Toast.LENGTH_SHORT).show();
        }

    }




}
