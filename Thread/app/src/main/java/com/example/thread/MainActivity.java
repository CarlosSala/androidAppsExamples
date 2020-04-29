package com.example.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = findViewById(R.id.tv1);
        Button btn1 = findViewById(R.id.btn1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Toast.makeText(MainActivity.this, "Boton pulsado", Toast.LENGTH_SHORT).show();
                miHilo();
            }
        });
        // miHilo();
    }

    final Handler mhandler = new Handler();

    protected void miHilo() {

        Thread thread = new Thread() {
            public void run() {
                try {

                    // this method run without sleep
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            //tv1.setText("soy runOnUiThread");
                           // Toast.makeText(MainActivity.this, "soy runOnUiThread", Toast.LENGTH_SHORT).show();
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

                mhandler.post(ejecutarAccion);
            }
        };
        thread.start();
    }

    private Runnable ejecutarAccion = new Runnable() {
        public void run() {
            //    setContentView(R.layout.activity_main_thread);
            Toast toast = Toast.makeText(MainActivity.this, "Soy un hilo", Toast.LENGTH_LONG);
            toast.setGravity(Gravity.TOP, 0, 400);

            View view = toast.getView();
            TextView view1 = view.findViewById(android.R.id.message);
            view1.setTextColor(Color.WHITE);
            view.setBackgroundResource(R.color.colorAccent);
            toast.show();
        }
    };
}