package com.example.retrofittutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.retrofittutorial.Interface.JsonPlaceHolderApi2;
import com.example.retrofittutorial.models.Posts;
import com.example.retrofittutorial.models.Response;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api2Activity extends AppCompatActivity {

    private TextView tv_post;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api2);

        Button btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Api2Activity.this, OldApiActivity.class);
                startActivity(intent);
            }
        });

        tv_post = findViewById(R.id.tv_post);

        GetPosts();

       // new Request().execute();
    }

    private void GetPosts() {

        final String url = "https://jsonplaceholder.typicode.com/";

        Retrofit retrofit = new Retrofit.Builder()

                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi2 jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi2.class);
        Call<List<Posts>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Posts>>() {
            @Override
            public void onResponse(Call<List<Posts>> call, retrofit2.Response<List<Posts>> response) {

                if (!response.isSuccessful()) {
                    tv_post.setText("Codigo: " + response.code());
                    return;
                }

                List<Posts> postsList = response.body();

                String content = "";

                for (Posts posts : postsList) {

                    content += "userId:" + posts.getUserId() + "\n";
                    content += "id:" + posts.getId() + "\n";
                    content += "title:" + posts.getTitle() + "\n";
                    content += "body:" + posts.getBody() + "\n\n";
                }

                tv_post.setText(content);

            }

            @Override
            public void onFailure(Call<List<Posts>> call, Throwable t) {
                tv_post.setText(t.getMessage());
            }
        });
    }


    // result are seeing in the logs
    public static class Request extends AsyncTask<Void, Void, Void> {


        @Override
        protected Void doInBackground(Void... voids) {

            final String url = "https://androidtutorials.herokuapp.com/";

            Retrofit retrofit = new Retrofit.Builder()

                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            JsonPlaceHolderApi2 service = retrofit.create(JsonPlaceHolderApi2.class);
            Call<List<Response>> response = service.postUsersFake();

            try {
                for (Response user : response.execute().body())
                    Log.e("Respuesta: ", user.getName() + " " + user.getNickName());

            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }
    }
}
