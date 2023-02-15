package com.example.examplerecyclerview1;

import static com.example.examplerecyclerview1.MainActivity.CREATOR;
import static com.example.examplerecyclerview1.MainActivity.LIKES;
import static com.example.examplerecyclerview1.MainActivity.URL;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Intent intent = getIntent();
        String imageUrl = intent.getStringExtra(URL);
        String creatorName = intent.getStringExtra(CREATOR);
        int likeCount = intent.getIntExtra(LIKES, 0);

        ImageView iv = findViewById(R.id.image_view_detail);
        TextView tv_creator = findViewById(R.id.text_view_creator_detail);
        TextView tv_likes = findViewById(R.id.text_view_like_detail);

        Picasso.get().load(imageUrl).fit().centerInside().into(iv);
        tv_creator.setText(creatorName);
        tv_likes.setText("likes: " + likeCount);


    }
}