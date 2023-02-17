package com.example.crudfirebase;

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

import com.example.crudfirebase.model.Person;
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

    EditText et_name, et_surname, et_email, et_password;
    ListView lv_person;

    private List<Person> listPerson = new ArrayList<Person>();
    ArrayAdapter<Person> arrayAdapterPerson;

    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    Person personSelected;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_name = findViewById(R.id.et_name);
        et_surname = findViewById(R.id.et_surname);
        et_email = findViewById(R.id.et_email);
        et_password = findViewById(R.id.et_password);
        lv_person = findViewById(R.id.lv_people);

        StartFirebase();

        ListPerson();

        lv_person.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                personSelected = (Person) adapterView.getItemAtPosition(position);
                et_name.setText(personSelected.getName());
                et_surname.setText(personSelected.getSurname());
                et_email.setText(personSelected.getEmail());
                et_password.setText(personSelected.getPassword());

            }
        });
    }

    private void ListPerson() {
        databaseReference.child("Person").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listPerson.clear();

                for (DataSnapshot objSnapshot : snapshot.getChildren()) {
                    Person person = objSnapshot.getValue(Person.class);
                    listPerson.add(person);

                    arrayAdapterPerson = new ArrayAdapter<Person>(MainActivity.this, android.R.layout.simple_list_item_1, listPerson);
                    lv_person.setAdapter(arrayAdapterPerson);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void StartFirebase() {
        FirebaseApp.initializeApp(this);
        firebaseDatabase = FirebaseDatabase.getInstance();
        // firebaseDatabase.setPersistenceEnabled(true);
        databaseReference = firebaseDatabase.getReference();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        String name = et_name.getText().toString();
        String surname = et_surname.getText().toString();
        String email = et_email.getText().toString();
        String password = et_password.getText().toString();

        switch (item.getItemId()) {

            case R.id.icon_add: {

                if (validation()) {

                    Person person = new Person();
                    person.setUid(UUID.randomUUID().toString());
                    person.setName(name);
                    person.setSurname(surname);
                    person.setEmail(email);
                    person.setPassword(password);

                    databaseReference.child("Person").child(person.getUid()).setValue(person);
                    Toast.makeText(this, "Added", Toast.LENGTH_SHORT).show();
                    CleanFields();
                }
                break;
            }

            case R.id.icon_save: {

                Person person = new Person();
                person.setUid(personSelected.getUid());
                person.setName(et_name.getText().toString().trim());
                person.setSurname(et_surname.getText().toString().trim());
                person.setEmail(et_email.getText().toString().trim());
                person.setPassword(et_password.getText().toString().trim());

                databaseReference.child("Person").child(person.getUid()).setValue(person);
                Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show();
                CleanFields();
                break;
            }
            case R.id.icon_delete: {

                Person person = new Person();
                person.setUid(personSelected.getUid());
                databaseReference.child("Person").child(person.getUid()).removeValue();
                Toast.makeText(this, "Removed", Toast.LENGTH_LONG).show();
                CleanFields();
                arrayAdapterPerson.notifyDataSetChanged();
                break;
            }
            default:
                break;
        }

        return true;
    }

    private void CleanFields() {
        et_name.setText("");
        et_surname.setText("");
        et_email.setText("");
        et_password.setText("");
    }

    private boolean validation() {

        boolean state = true;

        String string_name = et_name.getText().toString();
        String string_surname = et_surname.getText().toString();
        String string_email = et_email.getText().toString();
        String string_password = et_password.getText().toString();

        if (string_name.equals("")) {
            et_name.setError("Required");
            state = false;
        }
        if (string_surname.equals("")) {
            et_surname.setError("Required");
            state = false;
        }
        if (string_email.equals("")) {
            et_email.setError("Required");
            state = false;
        }
        if (string_password.equals("")) {
            et_password.setError("Required");
            state = false;
        }

        return state;
    }
}