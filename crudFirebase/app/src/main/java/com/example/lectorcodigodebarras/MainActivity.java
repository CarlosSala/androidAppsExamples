package com.example.lectorcodigodebarras;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lectorcodigodebarras.Models.Person;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MainActivity extends AppCompatActivity {

    private List<Person> listaPerson = new ArrayList<Person>();
    ArrayAdapter<Person> arrayAdapterPersona;

    EditText name, surname, email, password;
    ListView listView_personas;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Person personSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        name = findViewById(R.id.name);
        surname = findViewById(R.id.surname);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        listView_personas = findViewById(R.id.lv_datosPersonas);

        // Method for starting firebase
        StartFirebase();

        // Method for show info
        listarDatos();

        listView_personas.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                personSelected = (Person) parent.getItemAtPosition(position);
                name.setText(personSelected.getName());
                surname.setText(personSelected.getSurname());
                email.setText(personSelected.getEmail());
                password.setText(personSelected.getPassword());
            }
        });

    }

    private void listarDatos() {
        databaseReference.child("Persona").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                listaPerson.clear();
                for (DataSnapshot objSnapshot : dataSnapshot.getChildren()) {
                    Person person = objSnapshot.getValue(Person.class);
                    listaPerson.add(person);

                    arrayAdapterPersona = new ArrayAdapter<Person>(MainActivity.this, android.R.layout.simple_list_item_1, listaPerson);
                    listView_personas.setAdapter(arrayAdapterPersona);
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void StartFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        String string_name = name.getText().toString();
        String string_surname = surname.getText().toString();
        String string_email = email.getText().toString();
        String string_password = password.getText().toString();

        switch (item.getItemId()) {

            case R.id.icon_add: {
                if (validation()) {
                    Person person = new Person();
                    person.setName(string_name);
                    person.setSurname(string_surname);
                    person.setPassword(string_email);
                    person.setEmail(string_password);
                    person.setUid(UUID.randomUUID().toString());
                    databaseReference.child("Persona").child(person.getUid()).setValue(person);
                    Toast.makeText(this, "Added", Toast.LENGTH_LONG).show();
                    CleanFields();
                }
                break;
            }
            case R.id.icon_delete: {
                Person person = new Person();
                person.setUid(personSelected.getUid());
                databaseReference.child("Persona").child(person.getUid()).removeValue();
                Toast.makeText(this, "Removed", Toast.LENGTH_LONG).show();
                CleanFields();
                break;
            }
            case R.id.icon_save: {

                Person person = new Person();
                person.setUid(personSelected.getUid());
                person.setName(name.getText().toString().trim());
                person.setSurname(surname.getText().toString().trim());
                person.setEmail(email.getText().toString().trim());
                person.setPassword(password.getText().toString().trim());
                databaseReference.child("Persona").child(person.getUid()).setValue(person);
                CleanFields();

                Toast.makeText(this, "Updated", Toast.LENGTH_LONG).show();
                break;
            }
            default:
                break;
        }
        return true;
    }

    private void CleanFields() {
        name.setText("");
        surname.setText("");
        email.setText("");
        password.setText("");
    }

    private boolean validation() {

        boolean state = true;

        String string_name = name.getText().toString();
        String string_surname = surname.getText().toString();
        String string_email = email.getText().toString();
        String string_password = password.getText().toString();

        if (string_name.equals("")) {
            name.setError("Required");
            state = false;
        }
        if (string_surname.equals("")) {
            surname.setError("Required");
            state = false;
        }
        if (string_email.equals("")) {
            email.setError("Required");
            state = false;
        }
        if (string_password.equals("")) {
            password.setError("Required");
            state = false;
        }

        return state;
    }
}