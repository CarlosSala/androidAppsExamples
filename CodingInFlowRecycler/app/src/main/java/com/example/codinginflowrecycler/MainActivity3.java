package com.example.codinginflowrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.codinginflowrecycler.adapters.ExampleAdapter3;
import com.example.codinginflowrecycler.models.ExampleItem3;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleAdapter3 exampleAdapter3;
    private ArrayList<ExampleItem3> exampleItem3List;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        recyclerView = findViewById(R.id.rvLista);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        exampleItem3List = new ArrayList<>();

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
                startActivity(intent);
            }
        });

        data();
    }

    private void data() {

        exampleItem3List.add(new ExampleItem3("01/01/2018", "78"));
        exampleItem3List.add(new ExampleItem3("02/01/2018", "79"));
        exampleItem3List.add(new ExampleItem3("03/01/2018", "72"));
        exampleItem3List.add(new ExampleItem3("04/01/2018", "72"));
        exampleItem3List.add(new ExampleItem3("05/01/2018", "74"));
        exampleItem3List.add(new ExampleItem3("06/01/2018", "72"));
        exampleItem3List.add(new ExampleItem3("07/01/2018", "73"));
        exampleItem3List.add(new ExampleItem3("08/01/2018", "71"));
        exampleItem3List.add(new ExampleItem3("09/01/2018", "75"));
        exampleItem3List.add(new ExampleItem3("01/01/2018", "78"));
        exampleItem3List.add(new ExampleItem3("02/01/2018", "79"));
        exampleItem3List.add(new ExampleItem3("03/01/2018", "72"));
        exampleItem3List.add(new ExampleItem3("04/01/2018", "73"));
        exampleItem3List.add(new ExampleItem3("05/01/2018", "74"));
        exampleItem3List.add(new ExampleItem3("06/01/2018", "72"));
        exampleItem3List.add(new ExampleItem3("07/01/2018", "73"));
        exampleItem3List.add(new ExampleItem3("08/01/2018", "71"));
        exampleItem3List.add(new ExampleItem3("09/01/2018", "75"));

        exampleAdapter3 = new ExampleAdapter3(exampleItem3List);
        recyclerView.setAdapter(exampleAdapter3);

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(createHelperCallback());
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }


    private ItemTouchHelper.Callback createHelperCallback() {
        ItemTouchHelper.SimpleCallback simpleItemTouchCallback =
                new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP | ItemTouchHelper.DOWN,
                        ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

                    @Override
                    public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                        moveItem(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                        return false;
                    }

                    @Override
                    public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                        deleteItem(viewHolder.getAdapterPosition());
                    }
                };
        return simpleItemTouchCallback;
    }

    private void moveItem(int oldPos, int newPos) {
        ExampleItem3 item = (ExampleItem3) exampleItem3List.get(oldPos);
        exampleItem3List.remove(oldPos);
        exampleItem3List.add(newPos, item);
        exampleAdapter3.notifyItemMoved(oldPos, newPos);
    }

    private void deleteItem(final int position) {
        exampleItem3List.remove(position);
        exampleAdapter3.notifyItemRemoved(position);
    }

    public void delete(View view) {
        Toast.makeText(view.getContext(), "eliminar la cosa", Toast.LENGTH_SHORT).show();
    }
}
