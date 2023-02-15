package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView tv1, tv2;
    private EditText et1;
    private final Handler manejador = new Handler(Looper.getMainLooper());
    private Runnable tiempo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        tv1 = findViewById(R.id.tv_contadorAscendente);
        tv2 = findViewById(R.id.tv_contadorDescendente);
        et1 = findViewById(R.id.et_password);
        Button btn_ingresar = findViewById(R.id.btn_hilo3);

        tv2.setText("30");

        btn_ingresar.setOnClickListener(this::ingresar);

        // se crean 3 runnables, que se ejecutan al inicio, cada uno con su respectivo delay
        manejador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("pasaron 3 segundos");
            }
        }, 3000);

        manejador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("pasaron 6 segundos");
            }
        }, 6000);

        manejador.postDelayed(new Runnable() {
            @Override
            public void run() {
                tv1.setText("pasaron 9 segundos");
            }
        }, 9000);


        // se define otro runnable llamado tiempo, que se le pasa al manejador
        tiempo = new Runnable() {
            @Override
            public void run() {
                int valor = Integer.parseInt(tv2.getText().toString());
                if (valor==0)
                    finish();
                valor--;
                tv2.setText(String.valueOf(valor));
                // se ejecuta cada 1 seg el metodo run()
                manejador.postDelayed(this , 1000);
            }
        };

        // se inicia el runable tiempo despues de 5 seg
       manejador.postDelayed(tiempo,5000);
    }

    public void ingresar(View view){

        if (et1.getText().toString().equals("123"))
        {
            // detiene el runnable tiempo
            manejador.removeCallbacks(tiempo);
        }
    }
}