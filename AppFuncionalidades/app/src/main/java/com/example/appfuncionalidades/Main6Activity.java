package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Main6Activity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main6);

        et1 = findViewById(R.id.et_url);

        Button btn_nextActivity = findViewById(R.id.btn_nextActivity6);
        Button btn_navigate = findViewById(R.id.btn_navigate);

        btn_navigate.setOnClickListener(this::navigate);
        btn_nextActivity.setOnClickListener(this::next_activity);
    }

    public void navigate(View view) {
        Intent i = new Intent(this, Main7Activity.class);
        i.putExtra("website", et1.getText().toString());
        startActivity(i);
    }


    public void next_activity(View view) {
        Intent next = new Intent(this, Main8Activity.class);
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
