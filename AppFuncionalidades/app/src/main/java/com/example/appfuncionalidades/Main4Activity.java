package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main4Activity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main4);
        et1 = findViewById(R.id.et_text);

        Button btn_send = findViewById(R.id.btn_send);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity4);

        btn_send.setOnClickListener(this::send);
        btn_nextActivity.setOnClickListener(this::next_activity);
    }

    public void send(View view) {
        if (et1.length() > 0) {
            Intent i = new Intent(this, Main5Activity.class);
            i.putExtra("data", et1.getText().toString());
            startActivity(i);
        } else
            Toast.makeText(this, "Empty field!!", Toast.LENGTH_LONG).show();
    }


    public void next_activity(View view) {
        Intent next = new Intent(this, Main6Activity.class);
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
