package com.example.appfuncionalidades;

import android.app.Activity;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11Activity extends AppCompatActivity {

    private EditText et_name, et_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main11);

        et_name = findViewById(R.id.et_file);
        et_content = findViewById(R.id.et_content);
    }

    // save method
    public void save(View view) {
        String name = et_name.getText().toString();
        String content = et_content.getText().toString();

        try {
            File memorySD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, memorySD.getPath(), Toast.LENGTH_SHORT).show();
            File filePath = new File(memorySD.getPath(), name);
            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(name, Activity.MODE_PRIVATE));

            createFile.write(content);
            createFile.flush();
            createFile.close();

            //   Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
            et_name.setText("");
            et_content.setText("");
        } catch (IOException e) {
            Toast.makeText(this, "did not save file", Toast.LENGTH_SHORT).show();
        }
    }

    // search method
    public void search(View view) {
        String name = et_name.getText().toString();

        try {
            File memorySD = Environment.getExternalStorageDirectory();
            File filePath = new File(memorySD.getPath(), name);
            InputStreamReader file = new InputStreamReader(openFileInput(name));

            BufferedReader bufferedReader = new BufferedReader(file);
            String line = bufferedReader.readLine();
            String wholeContent = "";

            while (line != null) {
                wholeContent = wholeContent.concat(line + "\n");
                line = bufferedReader.readLine();
            }

            bufferedReader.close();
            file.close();
            et_content.setText(wholeContent);
        } catch (IOException e) {
            Toast.makeText(this, "could not read file", Toast.LENGTH_SHORT).show();
        }
    }

   /* public void Anterior(View view){
        Intent anterior = new Intent(this, Main10Activity.class);
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
