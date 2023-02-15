package com.example.retrofittutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class OldApiActivity extends AppCompatActivity implements Runnable{

    TextView tv_sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_api);

        tv_sal = findViewById(R.id.tv_salida);

        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OldApiActivity.this, Api1Activity.class);
                startActivity(intent);
            }
        });

        tv_sal.setText("trayendo la data...");


        getData();
    }


    public void getData() {


        Thread hilo = new Thread(this);
        hilo.start();
    }


    @Override
    public void run() {


        // String sql=  "https://api.myjson.com/bins/kmvba";
        String sql = "https://my-json-server.typicode.com/CarlosSala/response-json/posts";

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        URL url = null;
        HttpURLConnection conn;

        try {
            url = new URL(sql);
            conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("GET");

            conn.connect();

            BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String inputLine;

            StringBuffer response = new StringBuffer();


            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }


            runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    String json = response.toString();

                    tv_sal.setText(json);
                }
            });



        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
       /* catch (JSONException e) {
            e.printStackTrace();
        }*/
    }

    }