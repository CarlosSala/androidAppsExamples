package com.example.appfuncionalidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain8Binding;

public class Main8Activity extends AppCompatActivity {

    private ActivityMain8Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain8Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        binding.etEmail.setText(preferences.getString("email", ""));

        binding.btnSave.setOnClickListener(this::save);
        binding.btnNextActivity7.setOnClickListener(this::next_activity);
    }

    public void save(View view) {

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString("email", binding.etEmail.getText().toString());
        obj_editor.apply();
        finish();
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main9Activity.class);
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
