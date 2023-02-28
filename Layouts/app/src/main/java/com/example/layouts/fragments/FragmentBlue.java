package com.example.layouts.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.layouts.DynamicFragmentActivity;
import com.example.layouts.R;
import com.example.layouts.ScrollViewActivity;
import com.example.layouts.StaticsFragmentsActivity;
import com.example.layouts.TextInputLayoutActivity;

import java.util.Objects;


public class FragmentBlue extends Fragment {

    Button btn_next;

    public FragmentBlue() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View vista = inflater.inflate(R.layout.fragment_blue, container, false);

        btn_next = vista.findViewById(R.id.btn_next);

        // String activityActual = requireActivity().toString();

        String current_activity = requireActivity().toString().substring(0, 43);

        if (current_activity.equals("com.example.layouts.DynamicFragmentActivity")) {
            hidde_btn_next(getView());
        }

        btn_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), DynamicFragmentActivity.class);
                startActivity(intent);
            }
        });

        return vista;
    }

    public void hidde_btn_next(View view) {

        btn_next.setVisibility(View.INVISIBLE);
    }


}
