package com.example.appoperacions;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appoperacions.databinding.ActivityMain3Binding;

public class MainActivity3 extends AppCompatActivity {

    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String[] options = {"add", "rest", "multiplication", "division"};

        //R.layout.spinner_item_own path to the spinner in resource folder
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_own, options);
        binding.spinner.setAdapter(adapter);

        binding.btnCalculate2.setOnClickListener(this::Calculate);
    }

    //  method for calculate
    public void Calculate(View view) {

        String valueOneStr = binding.et1.getText().toString();
        String valueTwoStr = binding.et2.getText().toString();

        int valueOne = Integer.parseInt(valueOneStr);
        int valueTwo = Integer.parseInt(valueTwoStr);
        int result = 0;

        String selection = binding.spinner.getSelectedItem().toString();

        switch (selection) {
            case "add":
                result = valueOne + valueTwo;

                break;
            case "rest":
                result = valueOne - valueTwo;

                break;
            case "multiplication":
                result = valueOne * valueTwo;

                break;
            case "division":

                if (valueTwo == 0) {
                    Toast.makeText(this, "Value 2 can not be 0", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    result = valueOne / valueTwo;

                }
                break;
            default:
                Toast.makeText(this, "You must select an operation", Toast.LENGTH_SHORT).show();
                return;
        }

        binding.tv1.setText(String.valueOf(result));
    }

    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }
}
