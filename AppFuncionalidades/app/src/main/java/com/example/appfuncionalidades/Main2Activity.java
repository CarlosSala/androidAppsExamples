package com.example.appfuncionalidades;

import android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main2);
    }

    public void facebook(View my_view) {
        Toast.makeText(this, "You have touched Facebook", Toast.LENGTH_SHORT).show();
    }

    public void youtube(View view) {
        Toast.makeText(this, "You have touched Youtube", Toast.LENGTH_LONG).show();
    }

  /*  public void Anterior(View view) {
        onBackPressed();
    }*/

    public void next_activity(View view) {
        Intent next = new Intent(this, Main3Activity.class);
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
