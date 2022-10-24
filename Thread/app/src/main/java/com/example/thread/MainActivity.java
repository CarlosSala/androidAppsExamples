package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Runnable{

    TextView tv1;
    long suma;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        Button btn_hiloSuma = findViewById(R.id.btn_hiloSuma);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity);

        btn_hiloSuma.setOnClickListener(this::hiloSuma);

        btn_nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                startActivity(intent);
            }
        });
    }

    public void hiloSuma(View view){

        tv1.setText("Calculando el resultado...");
        Thread hilo = new Thread(this);
        hilo.start();
    }

    @Override
    public void run() {

        // algoritmo que tarda mucho tiempo
        suma = 0;

        for (long f=1; f<=2000000000; f++){
            suma+=f;
        }

        tv1.post(new Runnable() {
            @Override
            public void run() {
                tv1.setText("La suma desde 1 a 2000000000 es: " + suma);
            }
        });
    }

/*
    protected void myThread() {

        final Thread thread = new Thread() {
            public void run() {
                try {

                    // this method run without sleep
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {

                            // custom Toast
                            Toast toast = Toast.makeText(MainActivity.this, "Soy un hilo", Toast.LENGTH_LONG);
                            toast.setGravity(Gravity.TOP, 0, 400);
                            View view = toast.getView();
                            TextView view1 = view.findViewById(android.R.id.message);
                            view1.setTextColor(Color.WHITE);
                            view.setBackgroundResource(R.color.colorPrimaryDark);
                            toast.show();
                        }
                    });

                    // delay for post execute
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // wait for Thread.sleep before to execute action
                handler.post(executeAction);
            }
        };
        thread.start();
    }

    private Runnable executeAction = new Runnable() {

        public void run() {

            // custom Toast
            // setContentView(R.layout.activity_main_thread);
            Toast toast = Toast.makeText(MainActivity.this, "Soy un hilo", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 400);
            View view = toast.getView();
            TextView view1 = view.findViewById(android.R.id.message);
            view1.setTextColor(Color.WHITE);
            view.setBackgroundResource(R.color.colorAccent);
            toast.show();
        }
    };*/
}
