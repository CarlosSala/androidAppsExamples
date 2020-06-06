package com.androiddesdecero.viewmodel.ui;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androiddesdecero.viewmodel.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        configView();
    }

    private void configView(){

        Button btn_sumActivity = findViewById(R.id.btn_sumActivity);
        btn_sumActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), SumActivity.class));
            }
        });

        Button btViewModelUserActivity = findViewById(R.id.btn_userActivity);
        btViewModelUserActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), UserActivity.class));
            }
        });
        Button btLiveDataActivity = findViewById(R.id.btn_liveDataActivity);
        btLiveDataActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), LiveDataActivity.class));
            }
        });
    }
}
