package com.example.appoperacions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appoperacions.databinding.ActivityMain2Binding;

public class MainActivity2 extends AppCompatActivity {

    private ActivityMain2Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain2Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCalulate1.setOnClickListener(this::Calculate);
        binding.btnNextActivity1.setOnClickListener(this::Next_activity);
    }

    // method for calculate
    public void Calculate(View view) {

        int valueOne = Integer.parseInt(binding.et1.getText().toString());
        int valueTwo = Integer.parseInt(binding.et2.getText().toString());
        String result = "";

        if (binding.cbSuma.isChecked()) {
            int add = valueOne + valueTwo;
            result = "the add is: " + add + " / ";
        }
        if (binding.cbResta.isChecked()) {
            int rest = valueOne - valueTwo;
            result += "the rest is: " + rest;
        }
        binding.tv1.setText(result);
    }

    public void Next_activity(View view) {
        Intent next = new Intent(this, MainActivity3.class);
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
