package com.example.examplerecyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Adapter;

import com.example.examplerecyclerview1.adapter.AdapterRecyclerView;
import com.example.examplerecyclerview1.interfaces.JsonPlaceHolderApi;
import com.example.examplerecyclerview1.model.Item;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements AdapterRecyclerView.OnItemClickListener {

    public static final String URL = "imageUrl";
    public static final String CREATOR = "creatorName";
    public static final String LIKES = "likeCount";
    private final static String TAG = "verErrores";


    private RecyclerView mRecyclerView;
    private AdapterRecyclerView mAdapterRecyclerView;
    private ArrayList<Item> itemArrayList;
    private JsonPlaceHolderApi jsonPlaceHolderApi;

    final String url = "https://pixabay.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        itemArrayList = new ArrayList<>();

        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        GetPosts();
    }


    private void GetPosts(){

        Call<JsonObject> call = jsonPlaceHolderApi.getItems();

        call.enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                if (response.isSuccessful()) {
                   // Log.d(TAG, String.valueOf(response.body()));

                    try {

                        JsonArray jArray = response.body().getAsJsonArray("hits");

                        for (int i = 0; i < jArray.size(); i++) {

                            JsonObject hit = (JsonObject) jArray.get(i);

                            String creator = hit.get("user").getAsString();
                            int likes = hit.get("likes").getAsInt();
                            String imageUrl = hit.get("webformatURL").getAsString();

                            itemArrayList.add(new Item(imageUrl, creator, likes));
                        }

                        mAdapterRecyclerView = new AdapterRecyclerView(getApplicationContext(), itemArrayList);
                        mRecyclerView.setAdapter(mAdapterRecyclerView);
                        mAdapterRecyclerView.setOnItemClickListener(MainActivity.this);

                    }catch (JsonIOException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });
    }


    @Override
    public void onItemClick(int position) {

        Intent intent = new Intent(this, DetailActivity.class);
        Item clickedItem = itemArrayList.get(position);

        intent.putExtra(URL, clickedItem.getmImageUrl());
        intent.putExtra(CREATOR, clickedItem.getmCreator());
        intent.putExtra(LIKES, clickedItem.getmLikes());

        startActivity(intent);
    }
}