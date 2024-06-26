package com.example.mvvmarchitectureexample.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.mvvmarchitectureexample.R;

public class AddEditNoteActivity extends AppCompatActivity {

    public static final String EXTRA_ID =
            "mvvmarchitectureexample.EXTRA_ID";
    public static final String EXTRA_TITLE =
            "mvvmarchitectureexample.EXTRA_TITLE";
    public static final String EXTRA_DESCRIPTION =
            "mvvmarchitectureexample.EXTRA_DESCRIPTION";
    public static final String EXTRA_PRIORITY =
            "mvvmarchitectureexample.EXTRA_PRIORITY";

    private EditText et_title, et_description;
    private NumberPicker np_priority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        np_priority = findViewById(R.id.np_priority);

        np_priority.setMinValue(1);
        np_priority.setMaxValue(10);

        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);

        Intent intent = getIntent();

        if (intent.hasExtra(EXTRA_ID)) {
            setTitle("Edit Note");
            et_title.setText(intent.getStringExtra(EXTRA_TITLE));
            et_description.setText(intent.getStringExtra(EXTRA_DESCRIPTION));
            np_priority.setValue(intent.getIntExtra(EXTRA_PRIORITY, 1));
        } else {
            setTitle("Add Note");
        }
    }

    private void saveNote() {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        int priority = np_priority.getValue();

        if (title.trim().isEmpty() || description.trim().isEmpty()) {
            Toast.makeText(this, "Please insert a title and description", Toast.LENGTH_SHORT).show();
            return;
        }

        Intent data = new Intent();
        data.putExtra(EXTRA_TITLE, title);
        data.putExtra(EXTRA_DESCRIPTION, description);
        data.putExtra(EXTRA_PRIORITY, priority);

        int id = getIntent().getIntExtra(EXTRA_ID, 1);
        if (id != -1) {
            data.putExtra(EXTRA_ID, id);
        }

        setResult(RESULT_OK, data);
        finish();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.add_note_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (item.getItemId() == R.id.save_note) {
            saveNote();
            return true;
        }
        return super.onOptionsItemSelected(item);

    }
}