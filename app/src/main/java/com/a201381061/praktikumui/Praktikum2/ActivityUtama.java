package com.a201381061.praktikumui.Praktikum2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.a201381061.praktikumui.R;

public class ActivityUtama extends AppCompatActivity {

    Button buttonAdd;
    Button buttonList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);
        casting();
    }

    private void casting(){
        buttonAdd = (Button)findViewById(R.id.buttonAdd);
        buttonList = (Button)findViewById(R.id.buttonList);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bukaActivityRegister = new Intent(ActivityUtama.this,ActivityRegistrasi.class);
                startActivity(bukaActivityRegister);
            }
        });
    }

}
