package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain6Binding;

public class Main6Activity extends AppCompatActivity {

    private ActivityMain6Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain6Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnNavigate.setOnClickListener(this::navigate);
        binding.btnNextActivity6.setOnClickListener(this::next_activity);
    }

    public void navigate(View view) {
        Intent i = new Intent(this, Main7Activity.class);
        i.putExtra("website", binding.etUrl.getText().toString());
        startActivity(i);
    }


    public void next_activity(View view) {
        Intent next = new Intent(this, Main8Activity.class);
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
