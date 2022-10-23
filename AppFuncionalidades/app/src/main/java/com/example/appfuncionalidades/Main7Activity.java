package com.example.appfuncionalidades;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class Main7Activity extends AppCompatActivity {

    public WebView wv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main7);

        wv1 = findViewById(R.id.wv1);
        Button btn_closeWebView = findViewById(R.id.btn_closeWebview);

        String URL = getIntent().getStringExtra("website");
        wv1.setWebViewClient(new WebViewClient());
        wv1.loadUrl("https://" + URL);

        btn_closeWebView.setOnClickListener(this::close);
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
