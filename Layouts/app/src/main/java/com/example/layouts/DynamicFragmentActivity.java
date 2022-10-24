package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.layouts.fragments.FragmentBlue;
import com.example.layouts.fragments.FragmentGreen;
import com.example.layouts.fragments.FragmentRed;

public class DynamicFragmentActivity extends AppCompatActivity {

    FragmentRed fragmentRed;
    FragmentBlue fragmentBlue;
    FragmentGreen fragmentGreen;

    FragmentTransaction transaction;

    Button btn_fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dynamic_fragment);

        fragmentRed = new FragmentRed();
        fragmentBlue = new FragmentBlue();
        fragmentGreen = new FragmentGreen();

        getSupportFragmentManager().beginTransaction().add(R.id.containerFragments, fragmentRed).commit();

        btn_fragment = findViewById(R.id.linearLayout1);

        btn_fragment.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {

        transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {

            case R.id.btn_red:
                transaction.replace(R.id.containerFragments, fragmentRed);
                transaction.addToBackStack(null);
                break;
            case R.id.btn_blue:
                transaction.replace(R.id.containerFragments, fragmentBlue);
                transaction.addToBackStack(null);

                break;

            case R.id.btn_green:
                transaction.replace(R.id.containerFragments, fragmentGreen);
                transaction.addToBackStack(null);
                break;
        }

        transaction.commit();
    }

}
