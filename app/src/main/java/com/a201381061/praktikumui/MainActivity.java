package com.a201381061.praktikumui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

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
                loginOnline();
            }
        });
    }

    private void loginOnline(){
        final String isiUsername = etUsername.getText().toString();
        final String isiPassword = etPassword.getText().toString();

        String url = "http://tiw.web.id/api/mobileapi.php";
        JsonObjectRequest loginUser = new JsonObjectRequest(Request.Method.POST,
                url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                //INI BERHASIL
                Log.d("Response",response.toString());
                Toast.makeText(MainActivity.this, response.toString(), Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                //GAGAL
                Toast.makeText(MainActivity.this, "Login Gagal", Toast.LENGTH_SHORT).show();
            }
        }){

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("UserName",isiUsername);
                params.put("PassWord",isiPassword);
                return params;
            }

            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String,String> params = new HashMap<String,String>();
                params.put("appid","fasilkom");
                return params;
            }
        };

        MyApplication.getInstance().addToRequestQueue(loginUser,"ASDF");

    }



    private void loginOffline(){
        String isiUsername = etUsername.getText().toString();
        String isPassword = etPassword.getText().toString();

        if(isiUsername.equals("ADMIN")&&isPassword.equals("12345")){
            //INI KETIKA USER BERHASIL LOGIN
            //Toast.makeText(this,"Login Berhasil",Toast.LENGTH_SHORT).show();

            Intent masukHome = new Intent(MainActivity.this,HomeActivity.class);
            masukHome.putExtra("username",isiUsername);
            masukHome.putExtra("bonus","5 juta rupiah");
            masukHome.putExtra("dataangka",1000);
            startActivity(masukHome);


        }else{
            //INI KETIKA USER GAGAL LOGIN

            Toast.makeText(this,"Login Gagal",Toast.LENGTH_SHORT).show();
        }
    }

}