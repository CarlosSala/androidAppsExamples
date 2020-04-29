package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class DesignAdaptable1Activity extends AppCompatActivity {

    Button btn_next, btn_back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_adaptable);

        btn_next = findViewById(R.id.btn_next);
        btn_back = findViewById(R.id.btn_back);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DesignAdaptable1Activity.this, DesignAdaptable2Activity.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DesignAdaptable1Activity.this, FrameLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
