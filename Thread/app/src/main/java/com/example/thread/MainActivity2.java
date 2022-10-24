package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity implements Runnable{

    TextView tv;
    private long suma;
    private boolean banderaHilo = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        tv = findViewById(R.id.tv2);
        Button btn_hilo = findViewById(R.id.btn_hiloSuma2);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity2);

        btn_hilo.setOnClickListener(this::sumar);
        btn_nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });
    }

    public void sumar(View view){

        // bandera para evitar que el boton se presion muchas veces y genere muchos hilos
        if(banderaHilo == false) {

            banderaHilo = true;

            tv.setText("Calculando la suma....");

            Thread hilo = new Thread(this);
            hilo.start();
        }
    }

    @Override
    public void run() {

        suma = 0;
        for(long f=0; f<=2000000000; f++)
         suma+=f;
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv.setText("la suma de 1 al 2000.0000.000 es :" +suma);
                banderaHilo = false;
            }
        });
    }
}