package com.example.examplerecyclerview1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.examplerecyclerview1.adapter.ExampleAdapter;
import com.example.examplerecyclerview1.interfaces.JsonPlaceHolderApi;
import com.example.examplerecyclerview1.model.ExampleItem;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    public static final String URL = "imageUrl";
    public static final String CREATOR = "creatorName";
    public static final String LIKES = "likeCount";
    private final static String TAG = "verErrores";


    private RecyclerView mRecyclerView;
    private ExampleAdapter mExampleAdapter;
    private ArrayList<ExampleItem> exampleItemArrayList;

    private JsonPlaceHolderApi jsonPlaceHolderApi;

    final String url = "https://pixabay.com/";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        exampleItemArrayList = new ArrayList<>();

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
                    Log.d(TAG, String.valueOf(response.body()));
                }

                //  Log.d(TAG, String.valueOf(Post));

                try {

                    JsonArray jArray = response.body().getAsJsonArray("hits");

                    for (int i = 0; i < jArray.size(); i++) {

                        JsonObject hit = (JsonObject) jArray.get(i);

                        String creator = hit.get("user").getAsString();
                        int likes = hit.get("likes").getAsInt();
                        String imageUrl = hit.get("webformatURL").getAsString();

                        exampleItemArrayList.add(new ExampleItem(imageUrl, creator, likes));
                    }

                    mExampleAdapter = new ExampleAdapter(getApplicationContext(), exampleItemArrayList);
                    mRecyclerView.setAdapter(mExampleAdapter);

                }catch (JsonIOException e){
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

            }

        });
    }


}