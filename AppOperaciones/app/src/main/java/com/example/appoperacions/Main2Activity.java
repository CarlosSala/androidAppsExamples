package com.example.appoperacions;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1;
    private CheckBox cb1, cb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        cb1 = findViewById(R.id.cb_suma);
        cb2 = findViewById(R.id.cb_resta);
        tv1 = findViewById(R.id.tv1);
    }

    // method for calculate
    public void Calculate(View view) {

        int valor1_int = Integer.parseInt(et1.getText().toString());
        int valor2_int = Integer.parseInt(et2.getText().toString());
        String result = "";

        if (cb1.isChecked()) {
            int add = valor1_int + valor2_int;
            result = "the add is: " + add + " / ";
        }
        if (cb2.isChecked()) {
            int rest = valor1_int - valor2_int;
            result = result + "the rest is: " + rest;
        }
        tv1.setText(result);
    }

  /*  public void Anterior (View view){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }*/

    public void Next_activity(View view) {
        Intent next = new Intent(this, Main3Activity.class);
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
