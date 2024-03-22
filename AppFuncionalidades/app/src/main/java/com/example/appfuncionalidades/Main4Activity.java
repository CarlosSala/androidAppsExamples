package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain4Binding;

public class Main4Activity extends AppCompatActivity {

    private ActivityMain4Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain4Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSend.setOnClickListener(this::send);
        binding.btnNextActivity4.setOnClickListener(this::next_activity);
    }

    public void send(View view) {

        if (binding.etText.length() > 0) {

            Intent i = new Intent(this, Main5Activity.class);
            i.putExtra("data", binding.etText.getText().toString());
            startActivity(i);
        } else
            Toast.makeText(this, "Empty field!!", Toast.LENGTH_LONG).show();
    }


    public void next_activity(View view) {
        Intent next = new Intent(this, Main6Activity.class);
        startActivity(next);
    }

    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }
}
