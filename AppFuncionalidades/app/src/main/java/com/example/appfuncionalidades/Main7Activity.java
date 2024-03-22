package com.example.appfuncionalidades;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebViewClient;

import androidx.appcompat.app.AppCompatActivity;

import com.example.appfuncionalidades.databinding.ActivityMain7Binding;

public class Main7Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ActivityMain7Binding binding = ActivityMain7Binding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String URL = getIntent().getStringExtra("website");
        binding.wv1.setWebViewClient(new WebViewClient());
        binding.wv1.loadUrl("https://" + URL);

        binding.btnCloseWebview.setOnClickListener(this::close);
    }

    public void close(View view) {
        finish();
    }

    //method back of the toolbar
    @Override
    public boolean onSupportNavigateUp() {

        // onBackPressed();
        getOnBackPressedDispatcher().onBackPressed();

        return false;
    }
}
