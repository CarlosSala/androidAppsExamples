package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText mail, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        mail = findViewById(R.id.et_mail);
        password = findViewById(R.id.et_password);
    }

    public void signIn(View view) {

        if (mail.length() == 0) {
            Toast.makeText(this, "Complete with your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (password.length() == 0) {
            Toast.makeText(this, "Complete with your password", Toast.LENGTH_LONG).show();
            return;
        }
        if (mail.length() != 0 && password.length() != 0) {
            Toast.makeText(this, "wait one moment...", Toast.LENGTH_SHORT).show();
        }
    }

    /*public void Anterior (View view){
        Intent anterior = new Intent(this, Main2Activity.class);
        startActivity(anterior);
    }*/

    public void next_activity(View view) {
        Intent next = new Intent(this, Main4Activity.class);
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
