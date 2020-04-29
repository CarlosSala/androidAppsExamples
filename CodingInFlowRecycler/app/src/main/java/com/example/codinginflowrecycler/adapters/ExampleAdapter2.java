package com.example.codinginflowrecycler.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codinginflowrecycler.R;
import com.example.codinginflowrecycler.models.ExampleItem2;

import java.util.ArrayList;
import java.util.Collections;

public class ExampleAdapter2 extends RecyclerView.Adapter<ExampleAdapter2.ViewHolderDatos> {

    private ArrayList<ExampleItem2> mExampleItemList1;


    public ExampleAdapter2(ArrayList<ExampleItem2> data) {

        mExampleItemList1 = data;
    }

    @NonNull
    @Override
    public ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_string, null, false);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderDatos holder, int position) {

        ExampleItem2 currentItem = mExampleItemList1.get(position);

        holder.tv_id.setText(currentItem.getId());
        holder.tv_title.setText(currentItem.getTitle());
        holder.tv_body.setText(currentItem.getBody());

    }

    @Override
    public int getItemCount() {
        return mExampleItemList1.size();
    }


    class ViewHolderDatos extends RecyclerView.ViewHolder {

        TextView tv_id, tv_title, tv_body;


        ViewHolderDatos(@NonNull View itemView) {
            super(itemView);

            tv_id = itemView.findViewById(R.id.tv_id);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_body = itemView.findViewById(R.id.tv_body);

        }
    }

    public void onMove(int fromPosition, int toPosition) {
        if (fromPosition < toPosition) {
            for (int i = fromPosition; i < toPosition; i++) {
                Collections.swap(mExampleItemList1, i, i + 1);
            }
        } else {
            for (int i = fromPosition; i > toPosition; i--) {
                Collections.swap(mExampleItemList1, i, i - 1);
            }
        }
        notifyItemMoved(fromPosition, toPosition);
    }

    public void swipe(int position, int direction) {
        mExampleItemList1.remove(position);
        notifyItemRemoved(position);
    }

}
