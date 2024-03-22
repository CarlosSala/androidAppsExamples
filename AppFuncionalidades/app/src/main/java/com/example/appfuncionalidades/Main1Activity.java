package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain1Binding;

public class Main1Activity extends AppCompatActivity {

    private ActivityMain1Binding binding;
    private final String[] names = {"carlos", "martin", "ramiro", "marcelo", "mariana", "valeria"};
    private final String[] ages = {"18", "22", "21", "25", "29", "67"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain1Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnNextActivity.setOnClickListener(this::next_activity);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_item_own, names);
        binding.lv1.setAdapter(adapter);

        binding.lv1.setOnItemClickListener((adapterView, view1, i, l) -> {
            String lv_text = binding.lv1.getItemAtPosition(i) + " is " + ages[i] + " years old";
            binding.tv1.setText(lv_text);
        });
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main2Activity.class);
        startActivity(next);
    }
}