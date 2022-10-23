package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

public class Main1Activity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private final String[] names = {"carlos", "martin", "ramiro", "marcelo", "mariana", "valeria"};
    private final String[] ages = {"18", "22", "21", "25", "29", "67"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main1);

        tv1 = findViewById(R.id.tv1);
        lv1 = findViewById(R.id.lv1);
        Button btn1 = findViewById(R.id.btn_nextActivity);

       btn1.setOnClickListener(this::next_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_own, names);
        lv1.setAdapter(adapter);

        lv1.setOnItemClickListener((adapterView, view, i, l) -> {
            String lv_text = lv1.getItemAtPosition(i) + " is " + ages[i] + " years old";
            tv1.setText(lv_text);
        });
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main2Activity.class);
        startActivity(next);
    }
}