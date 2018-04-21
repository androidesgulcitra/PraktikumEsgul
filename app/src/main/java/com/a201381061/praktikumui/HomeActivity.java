package com.a201381061.praktikumui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvKataSambutan;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        casting();
        ambilData();
        buatKataSambutan();
    }

    private void casting(){
        tvKataSambutan = (TextView)findViewById(R.id.textViewHome);
    }

    private void ambilData(){
        userName = getIntent().getStringExtra("namauser");
    }

    private void buatKataSambutan(){
        tvKataSambutan.setText("Selamat Datang "+userName);
    }

}
