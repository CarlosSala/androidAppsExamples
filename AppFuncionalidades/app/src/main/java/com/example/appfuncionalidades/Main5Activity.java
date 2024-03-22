package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain5Binding;

public class Main5Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMain5Binding binding = ActivityMain5Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String data = getIntent().getStringExtra("data");
        String text = "Hello " + data;
        binding.tvReceived.setText(text);

        binding.btnNextActivity5.setOnClickListener(this::next_activity);
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
