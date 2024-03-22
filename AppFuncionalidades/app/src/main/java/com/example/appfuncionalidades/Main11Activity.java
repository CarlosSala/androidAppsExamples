package com.example.appfuncionalidades;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain11Binding;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main11Activity extends AppCompatActivity {
    private ActivityMain11Binding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMain11Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.btnSave.setOnClickListener(this::save);
        binding.btnSearch.setOnClickListener(this::search);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, 1);
        }
    }

    // save method
    public void save(View view) {

        String name = binding.etFile.getText().toString();
        String content = binding.etContent.getText().toString();

        try {

            File memorySD = Environment.getExternalStorageDirectory();
            Toast.makeText(this, memorySD.getPath(), Toast.LENGTH_SHORT).show();
            File filePath = new File(memorySD.getPath(), name);
            OutputStreamWriter createFile = new OutputStreamWriter(openFileOutput(name, Activity.MODE_PRIVATE));

            createFile.write(content);
            createFile.flush();
            createFile.close();

            //   Toast.makeText(this, "saved successfully", Toast.LENGTH_SHORT).show();
            binding.etFile.setText("");
            binding.etContent.setText("");

        } catch (IOException e) {
            Toast.makeText(this, "did not save file", Toast.LENGTH_SHORT).show();
        }
    }

    // search method
    public void search(View view) {

        String name = binding.etFile.getText().toString();

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
            binding.etContent.setText(wholeContent);

        } catch (IOException e) {
            Toast.makeText(this, "could not read file", Toast.LENGTH_SHORT).show();
        }
    }

    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }
}
