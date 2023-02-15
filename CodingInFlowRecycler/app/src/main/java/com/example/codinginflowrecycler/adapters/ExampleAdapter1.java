package com.example.codinginflowrecycler.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.codinginflowrecycler.models.ExampleItem1;
import com.example.codinginflowrecycler.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

// create recyclerview adapter
public class ExampleAdapter1 extends RecyclerView.Adapter<ExampleAdapter1.ExampleViewHolder> {

    private Context mContext;
    private ArrayList<ExampleItem1> mExampleItem1List;
    private OnItemClickListener mListener;

    // constructor
    public ExampleAdapter1(Context context, ArrayList<ExampleItem1> exampleList) {

        mContext = context;
        mExampleItem1List = exampleList;
    }

    // interface or guide
    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(mContext).inflate(R.layout.example_item, parent, false);
        return new ExampleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {

        ExampleItem1 currentItem = mExampleItem1List.get(position);

        holder.tv_creator.setText(currentItem.getCreator());
        int likeCount = currentItem.getLikeCount();
        holder.tv_likes.setText("Likes: " + likeCount);

        Picasso.get().load(currentItem.getImageUrl()).fit().centerInside().into(holder.iv);
    }

    @Override
    public int getItemCount() {
        return mExampleItem1List.size();
    }

    class ExampleViewHolder extends RecyclerView.ViewHolder {

        ImageView iv;
        TextView tv_creator, tv_likes;

        ExampleViewHolder(View itemView) {
            super(itemView);

            iv = itemView.findViewById(R.id.iv);
            tv_creator = itemView.findViewById(R.id.tv_creator);
            tv_likes = itemView.findViewById(R.id.tv_likes);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}

