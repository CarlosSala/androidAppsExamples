package com.example.appfuncionalidades;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Main9Activity extends AppCompatActivity {

    private EditText et_name, et_data;
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main9);

        et_name = findViewById(R.id.et_contact_name);
        et_data = findViewById(R.id.et_data);

        preferences = getSharedPreferences("schedule", Context.MODE_PRIVATE);
    }

    // save method
    public void save(View view) {
        String name = et_name.getText().toString();
        String data = et_data.getText().toString();

        SharedPreferences.Editor obj_editor = preferences.edit();
        obj_editor.putString(name, data);
        obj_editor.apply();

        Toast.makeText(this, "contact saved", Toast.LENGTH_SHORT).show();
    }

    // search method
    public void search(View view) {
        String name = et_name.getText().toString();

        String data = preferences.getString(name, "");

        if (data.length() == 0) {
            Toast.makeText(this, "contact not found", Toast.LENGTH_SHORT).show();
        } else {
            et_data.setText(data);
        }
    }

   /* public void Anterior (View view){
        Intent anterior = new Intent(this, Main8Activity.class);
        startActivity(anterior);
    }*/

    public void next_activity(View view) {
        Intent next = new Intent(this, Main10Activity.class);
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




