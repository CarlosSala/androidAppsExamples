package com.example.codinginflowrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.codinginflowrecycler.adapters.ExampleAdapter4;
import com.example.codinginflowrecycler.interfaces.ItemTouchListenner;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ExampleAdapter4 mAdapter;
    private ArrayList<String> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        recyclerView = findViewById(R.id.recycler_sample);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        arrayList = new ArrayList<>();

        getData();
    }

    private void addItemTouchCallback(RecyclerView recyclerView) {
        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(new ItemTouchListenner() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                mAdapter.onMove(oldPosition, newPosition);
            }

            @Override
            public void swipe(int position, int direction) {
                mAdapter.swipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

    private void getData() {

        for (int i = 0; i < 20; i++) {
            arrayList.add("Android " + i);
        }

        mAdapter = new ExampleAdapter4();
        mAdapter.addData(arrayList);
        recyclerView.setAdapter(mAdapter);
        addItemTouchCallback(recyclerView);
    }

}
