package com.example.codinginflowrecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.codinginflowrecycler.adapters.ExampleAdapter2;
import com.example.codinginflowrecycler.interfaces.ItemTouchListenner;
import com.example.codinginflowrecycler.interfaces.JsonPlaceHolderApi;
import com.example.codinginflowrecycler.models.ExampleItem2;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private ExampleAdapter2 mExampleAdapter2;
    private ArrayList<ExampleItem2> exampleItemArrayList1;

    private JsonPlaceHolderApi jsonPlaceHolderApi;
    final String url = "https://jsonplaceholder.typicode.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        mRecyclerView = findViewById(R.id.recyclerString);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        // recycler.setLayoutManager(new GridLayoutManager(this, 2));
        exampleItemArrayList1 = new ArrayList<>();

        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        GetPosts();

        Button btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
                startActivity(intent);
            }
        });

        // llenarPersonajes();
    }

   /* private void llenarPersonajes() {

        exampleItemArrayList1.add(new PersonajeVo("Krusty", "hola", R.drawable.krusti));
        exampleItemArrayList1.add(new PersonajeVo("Homero", "hola", R.drawable.homero));
        exampleItemArrayList1.add(new ExampleItem1("titulo1", "1", "98767541"));
        exampleItemArrayList1.add(new ExampleItem1("titulo2", "2", "98767542"));
        exampleItemArrayList1.add(new ExampleItem1("titulo3", "3", "98767543"));
        exampleItemArrayList1.add(new ExampleItem1("titulo4", "4", "98767544"));

        mExampleAdapter1 = new ExampleAdapter1(exampleItemArrayList1);
        mRecyclerView.setAdapter(mExampleAdapter1);
        addItemTouchCallback(mRecyclerView);
    }*/

    private void GetPosts() {

        Call<List<ExampleItem2>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<ExampleItem2>>() {
            @Override
            public void onResponse(Call<List<ExampleItem2>> call, Response<List<ExampleItem2>> response) {

                if (!response.isSuccessful()) {
                    //  tv_result.setText("Code: " + response.code());
                    return;
                }

                List<ExampleItem2> posts = response.body();

                for (ExampleItem2 post : posts) {

                    String id = post.getId();
                    String title = post.getTitle();
                    String body = post.getBody();

                    exampleItemArrayList1.add(new ExampleItem2(id, title, body));
                }

                mExampleAdapter2 = new ExampleAdapter2(exampleItemArrayList1);
                mRecyclerView.setAdapter(mExampleAdapter2);
                addItemTouchCallback(mRecyclerView);
                // mExampleAdapter1.setOnItemClickListener(Main1Activity.this);
            }

            @Override
            public void onFailure(Call<List<ExampleItem2>> call, Throwable t) {
                //   tv_result.setText(t.getMessage());
            }
        });
    }

    private void addItemTouchCallback(RecyclerView recyclerView) {

        ItemTouchHelper.Callback callback = new SimpleItemTouchHelperCallback(new ItemTouchListenner() {
            @Override
            public void onMove(int oldPosition, int newPosition) {
                mExampleAdapter2.onMove(oldPosition, newPosition);
            }

            @Override
            public void swipe(int position, int direction) {
                mExampleAdapter2.swipe(position, direction);
            }
        });
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }
}
