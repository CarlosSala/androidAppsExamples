package com.example.layouts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ScrollViewActitivy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);

        // icono en el action bar

        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.ic_launcher);
    }

    public void Selection(View view) {

        switch (view.getId()) {

            case R.id.banana:
                Toast.makeText(this, "Estas son bananas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.cherry:
                Toast.makeText(this, "Estas son cerezas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.strawberry:
                Toast.makeText(this, "Estas son frutillas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.kiwi:
                Toast.makeText(this, "Estos son kiwis", Toast.LENGTH_SHORT).show();
                break;

            case R.id.apples:
                Toast.makeText(this, "Estas son manzanas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.oranges:
                Toast.makeText(this, "Estas son naranjas", Toast.LENGTH_SHORT).show();
                break;

            case R.id.melons:
                Toast.makeText(this, "Estos son melones", Toast.LENGTH_SHORT).show();
                break;

            case R.id.pineapple:
                Toast.makeText(this, "Estas son piñas", Toast.LENGTH_SHORT).show();
                break;


            case R.id.pear:
                Toast.makeText(this, "Estas son peras", Toast.LENGTH_SHORT).show();
                break;


            case R.id.blackberry:
                Toast.makeText(this, "Estas son moras", Toast.LENGTH_SHORT).show();
                break;

            case R.id.watermelon:
                Toast.makeText(this, "Estos son sandias", Toast.LENGTH_SHORT).show();
                break;

            case R.id.grapes:
                Toast.makeText(this, "Estas son uvas", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
