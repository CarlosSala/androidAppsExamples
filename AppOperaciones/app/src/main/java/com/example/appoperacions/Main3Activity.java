package com.example.appoperacions;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private Spinner sp1;
    private EditText et1, et2;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        et1 = findViewById(R.id.et1);
        et2 = findViewById(R.id.et2);
        tv1 = findViewById(R.id.tv1);
        sp1 = findViewById(R.id.spinner);

        String[] options = {"add", "rest", "multiplication", "division"};

        //R.layout.spinner_item_own path to the spinner in resource folder
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.spinner_item_own, options);
        sp1.setAdapter(adapter);
    }

    //  method for calculate
    public void Calculate(View view) {

        String valor1_String = et1.getText().toString();
        String valor2_String = et2.getText().toString();

        int valor1_int = Integer.parseInt(valor1_String);
        int valor2_int = Integer.parseInt(valor2_String);
        int result = 0;

        String selection = sp1.getSelectedItem().toString();
        if (selection.equals("add")) {
            result = valor1_int + valor2_int;

        } else if (selection.equals("rest")) {
            result = valor1_int - valor2_int;

        } else if (selection.equals("multiplication")) {
            result = valor1_int * valor2_int;

        } else if (selection.equals("division")) {

            if (valor2_int == 0) {
                Toast.makeText(this, "Value 2 can not be 0", Toast.LENGTH_SHORT).show();
                return;
            } else {
                result = valor1_int / valor2_int;

            }
        } else {
            Toast.makeText(this, "You must select an operacion", Toast.LENGTH_SHORT).show();
            return;
        }

        String finalResult = String.valueOf(result);
        tv1.setText(finalResult);
    }

  /*  public void Anterior (View view){
        Intent anterior = new Intent(this, Main2Activity.class);
        startActivity(anterior);
    }*/

    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }
}
