package com.a201381061.praktikumui.Praktikum2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.a201381061.praktikumui.Praktikum1.MyApplication;
import com.a201381061.praktikumui.R;
import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class ActivityRegistrasi extends AppCompatActivity {

    private EditText etNama;
    private EditText etNim;
    private Button buttonRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrasi);
        casting();
    }

    private void casting(){
        etNama = (EditText)findViewById(R.id.editTextNama);
        etNim = (EditText)findViewById(R.id.editTextNIM);
        buttonRegister = (Button)findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strNama = etNama.getText().toString();
                String strNim = etNim.getText().toString();

                sendRegistrationData(strNama,strNim);

            }
        });
    }

    private void sendRegistrationData(final String nama,final String nim){
        String url = "http://reptiliadev.com/backendmobile/backend.php";

        StringRequest sendData = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.equals("Sukses")){
                            Toast.makeText(ActivityRegistrasi.this, "Registrasi Sukses", Toast.LENGTH_SHORT).show();
                        }else if(response.equals("Gagal")){
                            Toast.makeText(ActivityRegistrasi.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(ActivityRegistrasi.this, "Registrasi Gagal", Toast.LENGTH_SHORT).show();
                }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<>();
                params.put("nama",nama);
                params.put("nim",nim);
                return params;
            }
        };

        MyApplication.getInstance().addToRequestQueue(sendData,"SEND");

    }
}
