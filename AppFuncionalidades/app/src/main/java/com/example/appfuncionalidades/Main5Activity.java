package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main5Activity extends AppCompatActivity {

    public TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

        tv1 = findViewById(R.id.tv_received);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity5);

        String data = getIntent().getStringExtra("data");
        String text = "Hello " + data;
        tv1.setText(text);

        btn_nextActivity.setOnClickListener(this::next_activity);
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
