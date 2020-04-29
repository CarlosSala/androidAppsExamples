package com.example.retrofittutorial;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.retrofittutorial.Interface.JsonPlaceHolderApi1;
import com.example.retrofittutorial.models.Comments;
import com.example.retrofittutorial.models.Post;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Api1Activity extends AppCompatActivity {

    private JsonPlaceHolderApi1 jsonPlaceHolderApi1;
    final String url = "https://jsonplaceholder.typicode.com/";
    private TextView tv_result;
    Button btn_next;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_api1);

        tv_result = findViewById(R.id.tv_result);

        btn_next = findViewById(R.id.btn_next);
        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Api1Activity.this, OldApiActivity.class);
                startActivity(intent);
            }
        });

        Gson gson = new GsonBuilder().serializeNulls().create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        jsonPlaceHolderApi1 = retrofit.create(JsonPlaceHolderApi1.class);

        GetPosts();
        // GetComments();
        // GetQueryPosts();
        // CreatePost();
        // updatePost();
        // deletePost();
    }

    private void deletePost() {

        Call<Void> call = jsonPlaceHolderApi1.deletePost(5);

        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                tv_result.setText("Code: " + response.code());
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }


    private void GetPosts() {


        Call<List<Post>> call = jsonPlaceHolderApi1.getPosts();

        call.enqueue(new Callback<List<Post>>() {

            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                if (!response.isSuccessful()) {
                    tv_result.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                String content = "\n";

                for (Post post : posts) {

                    content += "\n" + "userId:" + post.getUserId() + "\n";
                    content += "id:" + post.getId() + "\n";
                    content += "title:" + post.getTitle() + "\n";
                    content += "body:" + post.getText() + "\n";
                }

                tv_result.append(content);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void GetComments() {

        Call<List<Comments>> call = jsonPlaceHolderApi1.getComments(5);

        //  Call<List<Comments>> call = jsonPlaceHolderApi.getComments("posts/3/comments");

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {

                if (!response.isSuccessful()) {
                    tv_result.setText("Code: " + response.code());
                    return;
                }

                //   String name = response.body().getClass().getName();

                List<Comments> ListComments = response.body();

                String content = "\n";

                for (Comments comment : ListComments) {

                    content += "ID:" + comment.getId() + "\n";
                    content += "Post ID:" + comment.getPostId() + "\n";
                    content += "Name:" + comment.getName() + "\n";
                    content += "Email:" + comment.getEmail() + "\n";
                    content += "Text:" + comment.getText() + "\n\n";
                }

                tv_result.append(content);
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void GetQueryPosts() {

        Map<String, String> parameters = new HashMap<>();
        parameters.put("userId", "1");
        parameters.put("_sort", "id");
        parameters.put("_order", "desc");

        Call<List<Post>> call = jsonPlaceHolderApi1.getPosts2(parameters);

//        Call<List<Post>> call = jsonPlaceHolderApi.getQueryPosts(new Integer[]{1,4,6},"id", "desc");

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code: " + response.code());
                    return;
                }

                //   String name = response.body().getClass().getName();

                List<Post> ListComments = response.body();

                String content = "";

                for (Post post : ListComments) {

                    content += "userId:" + post.getUserId() + "\n";
                    content += "id:" + post.getId() + "\n";
                    content += "title:" + post.getTitle() + "\n";
                    content += "body:" + post.getText() + "\n\n";
                }

                tv_result.append(content);
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void CreatePost() {

        Post post = new Post(1, "titular", "cuerpo");

        Map<String, String> fields = new HashMap<>();
        fields.put("userId", "5");
        fields.put("title", "mi_titular");

        Call<Post> call = jsonPlaceHolderApi1.createPost(fields);

        // Call<Post> call = jsonPlaceHolderApi.createPost(23, "mi_titulo", "cuerpo");

        // Call<Post> call = jsonPlaceHolderApi.createPost(post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {
                if (!response.isSuccessful()) {
                    tv_result.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();

                String content = "";
                content += "Code:" + response.code() + "\n";
                content += "userId:" + post.getUserId() + "\n";
                content += "id:" + post.getId() + "\n";
                content += "title:" + post.getTitle() + "\n";
                content += "body:" + post.getText() + "\n\n";

                tv_result.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }

    private void updatePost() {
        Post post = new Post(12, null, "new text");

        // you have to send the full payload
        //   Call<Post> call = jsonPlaceHolderApi.putPost(5, post);

        // you only send the parameters which you want to update
        Call<Post> call = jsonPlaceHolderApi1.patchPost(5, post);

        call.enqueue(new Callback<Post>() {
            @Override
            public void onResponse(Call<Post> call, Response<Post> response) {

                if (!response.isSuccessful()) {
                    tv_result.setText("Code: " + response.code());
                    return;
                }

                Post post = response.body();

                String content = "";
                content += "Code:" + response.code() + "\n";
                content += "userId:" + post.getUserId() + "\n";
                content += "id:" + post.getId() + "\n";
                content += "title:" + post.getTitle() + "\n";
                content += "body:" + post.getText() + "\n\n";

                tv_result.append(content);
            }

            @Override
            public void onFailure(Call<Post> call, Throwable t) {
                tv_result.setText(t.getMessage());
            }
        });
    }
}
