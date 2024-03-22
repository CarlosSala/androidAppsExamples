package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain2Binding;

public class Main2Activity extends AppCompatActivity {

    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

       ActivityMain2Binding binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.imageButton1.setOnClickListener(this::facebook);

        binding.imageButton2.setOnClickListener(this::youtube);

        binding.btnNextActivity2.setOnClickListener(this::next_activity);
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
            Toast.makeText(getApplicationContext(), "Press again to back", Toast.LENGTH_LONG).show();
            count++;
        } else {
            super.onBackPressed();
        }

        new CountDownTimer(3000, 1000) {

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
}
