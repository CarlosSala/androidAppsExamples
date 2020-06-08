package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class TextInputLayoutActivity extends AppCompatActivity {

    private TextInputLayout til_name;
    private TextInputLayout til_cel;
    private TextInputLayout til_email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_input_layout);
      /*  Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);*/

        til_name = findViewById(R.id.til_nombre);
        til_cel = findViewById(R.id.til_telefono);
        til_email = findViewById(R.id.til_correo);


        EditText et_name = findViewById(R.id.campo_nombre);
        EditText et_cel = findViewById(R.id.campo_telefono);
        EditText et_email = findViewById(R.id.campo_correo);

        et_name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_name.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_cel.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                til_cel.setError(null);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        et_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ValidateEmail(String.valueOf(s));
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        Button btn_back = findViewById(R.id.btn_back);
        Button btn_next = findViewById(R.id.btn_next);

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextInputLayoutActivity.this, TableLayoutActivity.class);
                startActivity(intent);
            }
        });

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TextInputLayoutActivity.this, StaticsFragmentsActivity.class);
                startActivity(intent);
            }
        });


        Button btn_accept = findViewById(R.id.btn_accept);
        btn_accept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ValidateData();
            }
        });

    }

    // check when accept button is press
    private boolean ValidateName(String nombre) {
        Pattern patron = Pattern.compile("^[a-zA-Z ]+$");
        if (!patron.matcher(nombre).matches() || nombre.length() > 30) {
            til_name.setError("Nombre inválido");
            return false;
        } else {
            til_name.setError(null);
        }

        return true;
    }

    // check when accept button is press
    private boolean ValidateCel(String telefono) {
        if (!Patterns.PHONE.matcher(telefono).matches()) {
            til_cel.setError("Teléfono inválido");
            return false;
        } else {
            til_cel.setError(null);
        }

        return true;
    }

    // check character to character
    private boolean ValidateEmail(String correo) {
        if (!Patterns.EMAIL_ADDRESS.matcher(correo).matches()) {
            til_email.setError("Correo electrónico inválido");
            return false;
        } else {
            til_email.setError(null);
        }

        return true;
    }

    private void ValidateData() {
        String name = til_name.getEditText().getText().toString();
        String cel = til_cel.getEditText().getText().toString();
        String email = til_email.getEditText().getText().toString();

        boolean a = ValidateName(name);
        boolean b = ValidateCel(cel);
        boolean c = ValidateEmail(email);

        if (a && b && c) {
            // OK, se pasa a la siguiente acción
            Toast.makeText(this, "Se guarda el registro", Toast.LENGTH_LONG).show();
        }

    }

}

