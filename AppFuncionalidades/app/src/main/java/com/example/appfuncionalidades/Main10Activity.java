package com.example.appfuncionalidades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main10Activity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main10);

        et1 = findViewById(R.id.et_notes);
        Button btn_save = findViewById(R.id.btn_save);
        Button btn_nextActivity = findViewById(R.id.btn_nextActivity9);

        //fileList(); recover files through an array
        String[] files = fileList();

        // read memorandum
        if (fileExists(files)) {
            try {
                InputStreamReader file = new InputStreamReader(openFileInput("memorandum.txt"));
                BufferedReader br = new BufferedReader(file);
                // check file is not empty
                String line = br.readLine();
                String WholeSchedule = "";

                while (line != null) {
                    WholeSchedule = WholeSchedule.concat(line + "\n");
                    line = br.readLine();
                }
                br.close();
                file.close();
                et1.setText(WholeSchedule);

            } catch (IOException e) {

            }
        }

        btn_save.setOnClickListener(this::save);
        btn_nextActivity.setOnClickListener(this::next_activity);
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
            file.write(et1.getText().toString());
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

