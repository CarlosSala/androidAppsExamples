package com.example.codinginflowrecycler.adapters;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codinginflowrecycler.ExampleDetailActivity3;
import com.example.codinginflowrecycler.R;
import com.example.codinginflowrecycler.models.ExampleItem3;

import java.util.ArrayList;

public class ExampleAdapter3 extends RecyclerView.Adapter<ExampleAdapter3.PesoViewHolder> {

    public static final String PESO = "PESO";
    public static final String FECHA = "FECHA";

    public ArrayList<ExampleItem3> exampleItem3s;

    public ExampleAdapter3(ArrayList<ExampleItem3> exampleItem3s) {
        this.exampleItem3s = exampleItem3s;
    }

    @NonNull
    @Override
    public PesoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        if (viewType == 0) {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_primero, parent, false);
        } else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        }
        return new PesoViewHolder(view);
    }

    // currency element into recyclerView
    @Override
    public void onBindViewHolder(PesoViewHolder pesoViewHolder, int position) {

        ExampleItem3 exampleItem3 = exampleItem3s.get(position);

        pesoViewHolder.tv_date.setText(exampleItem3.getmFecha());
        pesoViewHolder.tv_weight.setText(exampleItem3.getmPeso());

        double difference;
        String differenceString;

        if (position != 0) {
            ExampleItem3 exampleItem3MenosUno = exampleItem3s.get(position - 1);
            difference = Double.parseDouble(exampleItem3.getmPeso()) - Double.parseDouble(exampleItem3MenosUno.getmPeso());
            differenceString = String.valueOf(difference);
        } else {
            difference = 0;
            differenceString = "0";
        }
        pesoViewHolder.tv_difference.setText(differenceString);
        if (difference > 0) {
            pesoViewHolder.tv_difference.setTextColor(Color.parseColor("#64DD17"));
        } else if (difference == 0) {
            pesoViewHolder.tv_difference.setTextColor(Color.parseColor("#000000"));
        } else {
            pesoViewHolder.tv_difference.setTextColor(Color.parseColor("#D50000"));
        }
    }

    @Override
    public int getItemViewType(int position) {
        int viewType = 1;
        if (position == 0) viewType = 0;
        return viewType;
    }

    @Override
    public int getItemCount() {
        return exampleItem3s.size();
    }


    public class PesoViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_date, tv_weight, tv_difference;

        public PesoViewHolder(View itemView) {
            super(itemView);

            tv_date = itemView.findViewById(R.id.tv_date);
            tv_weight = itemView.findViewById(R.id.tv_weight);
            tv_difference = itemView.findViewById(R.id.tv_difference);

            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {

            Context context = view.getContext();
            int position = getAdapterPosition();
            ExampleItem3 exampleItem3 = exampleItem3s.get(position);
            Intent intent = new Intent(view.getContext(), ExampleDetailActivity3.class);
            intent.putExtra(PESO, exampleItem3.getmPeso());
            intent.putExtra(FECHA, exampleItem3.getmFecha());
            context.startActivity(intent);
        }
    }

}
