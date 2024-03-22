package com.example.appfuncionalidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain10Binding;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10Activity extends AppCompatActivity {
    private ActivityMain10Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain10Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //fileList(); recover files through an array
        String[] files = fileList();

        // read memorandum
        if (fileExists(files)) {

            try {

                InputStreamReader file = new InputStreamReader(openFileInput("memorandum.txt"));
                BufferedReader br = new BufferedReader(file);
                // check file is not empty
                String line = br.readLine();
                StringBuilder myDocument = new StringBuilder();

                while (line != null) {
                    myDocument.append(line).append("\n");
                    line = br.readLine();
                }
                br.close();
                file.close();
                binding.etNotes.setText(myDocument.toString());

            } catch (IOException e) {

            }
        }

        binding.btnSave.setOnClickListener(this::save);
        binding.btnNextActivity9.setOnClickListener(this::next_activity);
    }

    // check to exist memorandum
    private boolean fileExists(String[] files) {

        for (String file : files)
            if ("memorandum.txt".equals(file))
                return true;
        return false;
    }

    // save memorandum
    public void save(View view) {

        try {
            OutputStreamWriter file = new OutputStreamWriter(openFileOutput("memorandum.txt", Activity.MODE_PRIVATE));
            file.write(binding.etNotes.getText().toString());
            file.flush();
            file.close();
        } catch (IOException e) {

        }
        Toast.makeText(this, "memorandum saved successfully", Toast.LENGTH_LONG).show();
        finish();
    }

    public void next_activity(View view) {
        Intent next = new Intent(this, Main11Activity.class);
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

