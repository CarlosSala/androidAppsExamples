package com.example.appfuncionalidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain9Binding;

public class Main9Activity extends AppCompatActivity {

    private ActivityMain9Binding binding;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain9Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        preferences = getSharedPreferences("schedule", Context.MODE_PRIVATE);

        binding.btnSave.setOnClickListener(this::save);
        binding.btnSearch.setOnClickListener(this::search);
        binding.btnNextActivity8.setOnClickListener(this::next_activity);
    }

    // save method
    public void save(View view) {

        String name = binding.etContactName.getText().toString();
        String data = binding.etData.getText().toString();

        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, data);
        obj_editor.apply();

        Toast.makeText(this, "contact saved", Toast.LENGTH_SHORT).show();

        binding.etContactName.setText("");
        binding.etData.setText("");
    }

    // search method
    public void search(View view) {

        String name = binding.etContactName.getText().toString();
        String data = preferences.getString(name, "");

        if (data.isEmpty()) {
            Toast.makeText(this, "contact not found", Toast.LENGTH_SHORT).show();
        } else {
            binding.etData.setText(data);
        }
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main10Activity.class);
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




