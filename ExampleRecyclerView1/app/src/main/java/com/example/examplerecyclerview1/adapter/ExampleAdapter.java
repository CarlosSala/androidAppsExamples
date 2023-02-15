package com.example.examplerecyclerview1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplerecyclerview1.R;
import com.example.examplerecyclerview1.model.ExampleItem;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {


    private Context mContext;
    private ArrayList<ExampleItem> mExampleItemArrayList;
    private OnItemClickListener mLister;

    public ExampleAdapter(Context context, ArrayList<ExampleItem> exampleItemArrayList) {

        mContext = context;
        mExampleItemArrayList = exampleItemArrayList;
    }

    public interface OnItemClickListener{

        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mLister = listener;
    }

    @NonNull
    @Override
    public ExampleAdapter.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);

        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleAdapter.ExampleViewHolder holder, int position) {

        ExampleItem currentItem = mExampleItemArrayList.get(position);

        holder.tv_creator.setText(currentItem.getmCreator());
        int likeCount = currentItem.getmLikes();
        holder.tv_likes.setText("Likes: "+ likeCount);

        Picasso.get().load(currentItem.getmImageUrl()).fit().centerInside().into(holder.iv);

    }

    @Override
    public int getItemCount() {
        return mExampleItemArrayList.size();
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv_creator, tv_likes;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            tv_creator = itemView.findViewById(R.id.tv_creator);
            tv_likes = itemView.findViewById(R.id.tv_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    if(mLister != null){
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mLister.onItemClick(position);
                        }
                    }

                }
            });

        }
    }
}
