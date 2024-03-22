package com.example.appoperacions;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appoperacions.databinding.ActivityMain1Binding;

public class MainActivity1 extends AppCompatActivity {

    private ActivityMain1Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnCalculate.setOnClickListener(this::Calculate);
        binding.btnNextActivity.setOnClickListener(this::next_activity);
    }

    // method for calculate
    public void Calculate(View view) {

        int valueOne = Integer.parseInt(binding.et1.getText().toString());
        int valueTwo = Integer.parseInt(binding.et2.getText().toString());
        int result = 0;

        if (binding.rbAdd.isChecked()) {
            result = valueOne + valueTwo;

        } else if (binding.rbRest.isChecked()) {
            result = valueOne - valueTwo;

        } else if (binding.rbMulti.isChecked()) {
            result = valueOne * valueTwo;

        } else if (binding.rbDivision.isChecked()) {
            if (valueTwo == 0) {
                Toast.makeText(this, "Value 2 cannot be 0", Toast.LENGTH_LONG).show();
            } else {
                result = valueOne / valueTwo;
            }
        } else {
            Toast.makeText(this, "Select an operation", Toast.LENGTH_LONG).show();
            return;
        }

        binding.tv1.setText(String.valueOf(result));
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, MainActivity2.class);
        startActivity(next);
    }
}