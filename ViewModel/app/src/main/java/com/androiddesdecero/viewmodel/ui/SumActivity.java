package com.androiddesdecero.viewmodel.ui;

import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.androiddesdecero.viewmodel.R;
import com.androiddesdecero.viewmodel.Sum;
import com.androiddesdecero.viewmodel.viewmodel.SumViewModel;

public class SumActivity extends AppCompatActivity {

    private TextView tv_sumActivity, tv_sumViewModel;
    private int number;
    private SumViewModel sumViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sumar);

        tv_sumActivity = findViewById(R.id.tv_sumActivity);
        tv_sumViewModel = findViewById(R.id.tv_sumActivityViewModel);
        Button btn_sum = findViewById(R.id.btn_sum);

        // number for defect is 0
        tv_sumActivity.setText(" " + number);

        // get viewModel
        sumViewModel = new ViewModelProvider(this).get(SumViewModel.class);
        tv_sumViewModel.setText(" " + sumViewModel.getResult());

        btn_sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                number = Sum.sum(number);
                tv_sumActivity.setText(" " + number);

                sumViewModel.setResult(Sum.sum(sumViewModel.getResult()));
                tv_sumViewModel.setText(" " + sumViewModel.getResult());
            }
        });
    }
}
