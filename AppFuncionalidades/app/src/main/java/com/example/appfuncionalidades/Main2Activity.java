package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);

        ImageButton ib_facebook = findViewById(R.id.imageButton1);
        ImageButton ib_youtube = findViewById(R.id.imageButton2);
        Button btn1 = findViewById(R.id.btn_nextActivity2);

        ib_facebook.setOnClickListener(this::facebook);

        ib_youtube.setOnClickListener(this::youtube);

        btn1.setOnClickListener(this::next_activity);
    }

    public void facebook(View my_view) {
        Toast.makeText(this, "You have touched Facebook", Toast.LENGTH_SHORT).show();
    }

    public void youtube(View view) {
        Toast.makeText(this, "You have touched Youtube", Toast.LENGTH_LONG).show();
    }

  /*  public void Anterior(View view) {
        onBackPressed();
    }*/

    public void next_activity(View view) {
        Intent next = new Intent(this, Main3Activity.class);
        startActivity(next);
    }

    @Override
    public void onBackPressed() {

        if (count == 0) {
            Toast.makeText(getApplicationContext(), "Presione de nuevo para regresar", Toast.LENGTH_LONG).show();
            count++;
        } else {
            super.onBackPressed();
        }

        new CountDownTimer(3000, 1000){

            // every time that pass 1000 ms does any action
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                count = 0;
            }
        }.start();
    }


    /*    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }*/
}
