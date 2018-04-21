package com.a201381061.praktikumui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class HomeActivity extends AppCompatActivity {

    TextView tvKataSambutan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        casting();
    }

    private void casting(){
        tvKataSambutan = (TextView)findViewById(R.id.textViewHome);
    }

}
