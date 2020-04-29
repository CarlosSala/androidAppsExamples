package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class FrameLayoutActivity extends AppCompatActivity {

    private ImageView iv1;
    private Button btn_show;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_layout);

        iv1 = findViewById(R.id.imageView);
        btn_show = findViewById(R.id.button);
        Button btn_next = findViewById(R.id.button1);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FrameLayoutActivity.this, DesignAdaptable1Activity.class);
                startActivity(intent);
            }
        });
    }

    public void Show(View view) {

        btn_show.setVisibility(View.INVISIBLE);
        iv1.setVisibility(View.VISIBLE);
    }

    public void HideImage(View view) {

        btn_show.setVisibility(View.VISIBLE);
        iv1.setVisibility(View.INVISIBLE);
    }
}