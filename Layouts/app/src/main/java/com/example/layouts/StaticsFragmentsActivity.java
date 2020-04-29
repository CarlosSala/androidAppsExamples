package com.example.layouts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.layouts.fragments.FragmentBlue;
import com.example.layouts.fragments.FragmentGreen;
import com.example.layouts.fragments.FragmentRed;


public class StaticsFragmentsActivity extends AppCompatActivity {

    Button btn_back, btn_next;

    FragmentRed fragmentRed;
    FragmentBlue fragmentBlue;
    FragmentGreen fragmentGreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_statics_fragments);

        fragmentRed = new FragmentRed();
        fragmentBlue = new FragmentBlue();
        fragmentGreen = new FragmentGreen();

        btn_back = findViewById(R.id.btn_back);
        btn_next = findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaticsFragmentsActivity.this.getBaseContext(), DynamicFragmentActivity.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(StaticsFragmentsActivity.this.getBaseContext(), TextInputLayoutActivity.class);
                startActivity(intent);
            }
        });
    }
}
