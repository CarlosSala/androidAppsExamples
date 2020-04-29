package com.example.layouts.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.layouts.DynamicFragmentActivity;
import com.example.layouts.R;
import com.example.layouts.ScrollViewActitivy;
import com.example.layouts.StaticsFragmentsActivity;
import com.example.layouts.TextInputLayoutActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBlue extends Fragment {

    public FragmentBlue() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_blue, container, false);

        Button btn_back = vista.findViewById(R.id.btn_back);
        Button btn_next = vista.findViewById(R.id.btn_next);

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ScrollViewActitivy.class);
                startActivity(intent);
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), StaticsFragmentsActivity.class);
                startActivity(intent);
            }
        });

        return vista;
    }
}
