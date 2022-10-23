package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main3Activity extends AppCompatActivity {

    private EditText et_mail, et_password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main3);

        et_mail = findViewById(R.id.et_mail);
        et_password = findViewById(R.id.et_password);
        Button btn_signIN = findViewById(R.id.btn_signIn);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity3);

        btn_signIN.setOnClickListener(this::signIn);
        btn_nextActivity.setOnClickListener(this::next_activity);
    }

    public void signIn(View view) {

        if (et_mail.length() == 0) {
            Toast.makeText(this, "Complete with your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (et_password.length() == 0) {
            Toast.makeText(this, "Complete with your password", Toast.LENGTH_LONG).show();
            return;
        }
        if (et_mail.length() != 0 && et_password.length() != 0) {
            Toast.makeText(this, "wait one moment...", Toast.LENGTH_SHORT).show();
        }
    }


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
