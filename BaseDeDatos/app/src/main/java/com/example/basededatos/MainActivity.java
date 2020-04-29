package com.example.basededatos;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basededatos.utilities.Utilities;

public class MainActivity extends AppCompatActivity {

    private EditText et_id, et_name, et_cell;
    private Button btn_register, btn_search, btn_update, btn_delete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        et_name = findViewById(R.id.et_name);
        et_cell = findViewById(R.id.et_cell);

        btn_register = findViewById(R.id.button1);
        btn_search = findViewById(R.id.button2);
        btn_update = findViewById(R.id.button3);
        btn_delete = findViewById(R.id.button4);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Register(v);
                RegisterSQL(v);
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Search(v);
            }
        });

        btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delete(v);
            }
        });

        btn_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Update(v);
            }
        });
    }

    public void RegisterSQL(View view) {
        ConnectionSQLiteHelper admin = new ConnectionSQLiteHelper(this, "clients", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        String name = et_name.getText().toString();
        String cell = et_cell.getText().toString();

        if (!id.isEmpty() && !name.isEmpty() && !cell.isEmpty()) {


            // insert into users (id, name, cell) values (123, 'carlos', '454560');

            String insert = "INSERT INTO " + Utilities.USERS_TABLE
                    + " ( " +
                    Utilities.ID_FIELD
                    + "," +
                    Utilities.NAME_FIELD
                    + " , " +
                    Utilities.CELL_FIELD
                    + " ) VALUES (" + id + ", '" + name + "','" + cell + "' ) ";

            sqLiteDatabase.execSQL(insert);

            et_id.setText("");
            et_name.setText("");
            et_cell.setText("");

            Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();

            // Toast.makeText(this, "Client wasn't registered", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You must complete all of the fields", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
    }


    // Method for registration clients
    public void Register(View view) {
        ConnectionSQLiteHelper admin = new ConnectionSQLiteHelper(this, "clients", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        String name = et_name.getText().toString();
        String cell = et_cell.getText().toString();

        if (!id.isEmpty() && !name.isEmpty() && !cell.isEmpty()) {

            ContentValues register = new ContentValues();
            register.put(Utilities.ID_FIELD, id);
            register.put(Utilities.NAME_FIELD, name);
            register.put(Utilities.CELL_FIELD, cell);

            Long result = sqLiteDatabase.insert(Utilities.USERS_TABLE, Utilities.ID_FIELD, register);

            et_id.setText("");
            et_name.setText("");
            et_cell.setText("");

            Toast.makeText(this, "Registration successful", Toast.LENGTH_LONG).show();

            // Toast.makeText(this, "Client wasn't registered", Toast.LENGTH_LONG).show();

        } else {
            Toast.makeText(this, "You must complete all of the fields", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
    }

    // Method for search clients
    public void Search(View view) {
        ConnectionSQLiteHelper admin = new ConnectionSQLiteHelper(this, "clients", null, 1);
        SQLiteDatabase sqLiteDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();

        if (!id.isEmpty()) {
            Cursor row = sqLiteDatabase.rawQuery
                    ("select name, cell from users where id =" + id, null);

            if (row.moveToFirst()) {
                et_name.setText(row.getString(0));
                et_cell.setText(row.getString(1));

            } else {
                Toast.makeText(this, "Doesn't found client", Toast.LENGTH_SHORT).show();

            }

        } else {
            Toast.makeText(this, "You must enter a client id", Toast.LENGTH_SHORT).show();
        }
        sqLiteDatabase.close();
    }

    // Method for update the information client
    public void Update(View view) {
        ConnectionSQLiteHelper admin = new ConnectionSQLiteHelper(this, "clients", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();
        String name = et_name.getText().toString();
        String cell = et_cell.getText().toString();

        if (!id.isEmpty() && !name.isEmpty() && !cell.isEmpty()) {

            ContentValues register = new ContentValues();
            register.put(Utilities.ID_FIELD, id);
            register.put(Utilities.NAME_FIELD, name);
            register.put(Utilities.CELL_FIELD, cell);

            int quantity = BaseDatabase.update("users", register, "id=" + id, null);

            if (quantity == 1) {
                et_id.setText("");
                et_name.setText("");
                et_cell.setText("");
                Toast.makeText(this, "Client has been updated successful", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Client doesn't exist", Toast.LENGTH_SHORT).show();
            }


        } else {
            Toast.makeText(this, "You must complete all of the fields", Toast.LENGTH_SHORT).show();
        }
        BaseDatabase.close();
    }

    // Method for delete a client
    public void Delete(View view) {
        ConnectionSQLiteHelper admin = new ConnectionSQLiteHelper(this, "clients", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String id = et_id.getText().toString();

        if (!id.isEmpty()) {

            int quantity = BaseDatabase.delete("users", "id=" + id, null);

            if (quantity == 1) {
                et_id.setText("");
                et_name.setText("");
                et_cell.setText("");

                Toast.makeText(this, "Client has been deleted successful", Toast.LENGTH_SHORT).show();
            } else
                Toast.makeText(this, "Client doesn't exist", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "You must enter a client id", Toast.LENGTH_SHORT).show();
        }
        BaseDatabase.close();
    }
}
