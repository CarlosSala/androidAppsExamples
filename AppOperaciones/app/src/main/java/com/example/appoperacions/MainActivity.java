package com.example.appoperacions;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private RadioButton rb1, rb2, rb3, rb4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        rb1 = findViewById(R.id.rb_add);
        rb2 = findViewById(R.id.rb_rest);
        rb3 = findViewById(R.id.rb_multi);
        rb4 = findViewById(R.id.rb_division);
        tv1 = findViewById(R.id.tv1);

        Button btn_calculate = findViewById(R.id.btn_calculate);
        btn_calculate.setOnClickListener(this::Calculate);

        Button btn_nextActivity = findViewById(R.id.btn_nextActivity);
        btn_nextActivity.setOnClickListener(this::next_activity);
    }

    // method for calculate
    public void Calculate(View view) {
        int valor1_int = Integer.parseInt(et1.getText().toString());
        int valor2_int = Integer.parseInt(et2.getText().toString());
        int result = 0;

        if (rb1.isChecked()) {
            result = valor1_int + valor2_int;

        } else if (rb2.isChecked()) {
            result = valor1_int - valor2_int;

        } else if (rb3.isChecked()) {
            result = valor1_int * valor2_int;

        } else if (rb4.isChecked()) {
            if (valor2_int == 0) {
                Toast.makeText(this, "Value 2 cannot be 0", Toast.LENGTH_LONG).show();
            } else {
                result = valor1_int / valor2_int;
            }
        } else {
            Toast.makeText(this, "Select an operation", Toast.LENGTH_LONG).show();
            return;
        }

        String finalResult = String.valueOf(result);
        tv1.setText(finalResult);
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main2Activity.class);
        startActivity(next);
    }
}