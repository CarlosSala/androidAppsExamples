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

public class OldApiActivity extends AppCompatActivity {

    TextView sal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_old_api);

        sal = findViewById(R.id.salida);

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OldApiActivity.this, Api2Activity.class);
                startActivity(intent);
            }
        });

        Button btn_back = findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OldApiActivity.this, Api1Activity.class);
                startActivity(intent);
            }
        });

        getData();
    }


    public void getData() {


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

            String json = response.toString();


/*            JSONArray jsonArr = null;

            JSONObject jsonObject = new JSONObject(json);
            jsonArr = jsonObject.getJSONArray("projects");

//            jsonArr = new JSONArray(json);
            String mensaje = "";
            //for(int i = 0;i<jsonObject.length();i++){

            //   JSONObject jsonObject = jsonArr.getJSONObject(i);

            // Log.d("SLIDA",jo.optString("name"));
            mensaje += "id " + " " + jsonArr.getString(0) + "\n";
            //  }
             sal.setText(mensaje);
            */


            sal.setText(json);
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
