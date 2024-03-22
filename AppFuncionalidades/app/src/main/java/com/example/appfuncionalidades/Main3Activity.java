package com.example.appfuncionalidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain3Binding;

public class Main3Activity extends AppCompatActivity {

    private ActivityMain3Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain3Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSignIn.setOnClickListener(this::signIn);
        binding.btnNextActivity3.setOnClickListener(this::next_activity);
    }

    public void signIn(View view) {

        if (binding.etMail.length() == 0) {
            Toast.makeText(this, "Complete with your email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (binding.etPassword.length() == 0) {
            Toast.makeText(this, "Complete with your password", Toast.LENGTH_LONG).show();
            return;
        }
        if (binding.etMail.length() != 0 && binding.etPassword.length() != 0) {
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
