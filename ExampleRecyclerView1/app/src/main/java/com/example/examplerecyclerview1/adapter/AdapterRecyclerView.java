package com.example.examplerecyclerview1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examplerecyclerview1.R;
import com.example.examplerecyclerview1.model.Item;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class AdapterRecyclerView extends RecyclerView.Adapter<AdapterRecyclerView.ExampleViewHolder> {

    private final Context mContext;
    private final ArrayList<Item> mItemArrayList;
    private OnItemClickListener mLister;

    public AdapterRecyclerView(Context context, ArrayList<Item> itemArrayList) {

        mContext = context;
        mItemArrayList = itemArrayList;
    }



    public interface OnItemClickListener{

        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mLister = listener;
    }


    @NonNull
    @Override
    public AdapterRecyclerView.ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);

        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterRecyclerView.ExampleViewHolder holder, int position) {

        Item currentItem = mItemArrayList.get(position);

        holder.tv_creator.setText(currentItem.getmCreator());

        int likeCount = currentItem.getmLikes();
        holder.tv_likes.setText("Likes: "+ likeCount);

        Picasso.get().load(currentItem.getmImageUrl()).fit().centerInside().into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mItemArrayList.size();
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
                        int position = getLayoutPosition();
                        if (position != RecyclerView.NO_POSITION){
                            mLister.onItemClick(position);
                        }
                    }

                }
            });

        }
    }
}
