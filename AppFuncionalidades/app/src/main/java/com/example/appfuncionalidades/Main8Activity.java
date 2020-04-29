package com.example.appfuncionalidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Main8Activity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main8);

        et1 = findViewById(R.id.et_email);

        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        et1.setText(preferences.getString("email", ""));
    }

    public void save(View view) {
        SharedPreferences preferences = getSharedPreferences("info", Context.MODE_PRIVATE);
        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString("email", et1.getText().toString());
        obj_editor.apply();
        finish();
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main9Activity.class);
        startActivity(next);
    }

    /*public void Anterior (View view){
        Intent anterior = new Intent(this, Main6Activity.class);
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
