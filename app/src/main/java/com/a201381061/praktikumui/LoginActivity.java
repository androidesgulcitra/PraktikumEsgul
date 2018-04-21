package com.a201381061.praktikumui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity{

    EditText etUsername;
    EditText etPassword;
    Button buttonLogin;
    TextView tvJudul;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        casting();
    }

    private void casting(){
        //CASTING
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
        String isiPassword = etPassword.getText().toString();

        if(isiUsername.equals("ADMIN")&&isiPassword.equals("12345")){

            //LOGIN BERHASIL
            //Toast.makeText(LoginActivity.this,"Login Berhasil",Toast.LENGTH_SHORT).show();

            Intent masukHome = new Intent(LoginActivity.this,HomeActivity.class);
            masukHome.putExtra("namauser",isiUsername);
            startActivity(masukHome);


        }else{
            //LOGIN GAGAL
            Toast.makeText(LoginActivity.this,"Login Gagal",Toast.LENGTH_SHORT).show();
        }
    }


}