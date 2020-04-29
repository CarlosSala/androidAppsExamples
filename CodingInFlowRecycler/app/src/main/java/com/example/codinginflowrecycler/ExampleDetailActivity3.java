package com.example.codinginflowrecycler;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.codinginflowrecycler.adapters.ExampleAdapter3.FECHA;
import static com.example.codinginflowrecycler.adapters.ExampleAdapter3.PESO;

public class ExampleDetailActivity3 extends AppCompatActivity {

        private String mPeso;
        private String mFecha;
        private Button btn_delete;

        public MainActivity3 mainActivity3;

        TextView tvPeso;
        TextView tvFecha;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_peso_editar);

            mPeso = getIntent().getStringExtra(PESO);
            mFecha = getIntent().getStringExtra(FECHA);

            tvFecha = findViewById(R.id.fecha);
            tvFecha.setText(mFecha);
            tvPeso = findViewById(R.id.tv_weight);
            tvPeso.setText(mPeso);

            mainActivity3 = new MainActivity3();


            btn_delete = findViewById(R.id.btn_delete);
            btn_delete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mainActivity3.delete(view);
                }
            });

        }


   /* public void delete(View view) {
        mainActivity.delete(view);
    }*/
    }

