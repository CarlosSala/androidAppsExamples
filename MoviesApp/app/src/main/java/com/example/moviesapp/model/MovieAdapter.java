package com.example.moviesapp.model;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviesapp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieHolder> {

    private List<Movie> movies = new ArrayList<>();

    public MovieAdapter(List<Movie> movies) {
        this.movies = movies;
    }

    @NonNull
    @Override
    public MovieHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.movie_item, parent, false);

        return new MovieHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieHolder holder, int position) {

        Movie currentMovie = movies.get(position);
        holder.tv_source.setText(currentMovie.getSource().getName());
        holder.tv_title.setText(currentMovie.getTitle());
        holder.tv_description.setText(currentMovie.getDescription());
        Picasso.get().load(currentMovie.getUrlToImage()).fit().centerInside().into(holder.iv);
    }


    @Override
    public int getItemCount() {
        return movies.size();
    }

    public class MovieHolder extends RecyclerView.ViewHolder {

        private TextView tv_source, tv_title, tv_description;
        private ImageView iv;

        public MovieHolder(@NonNull View itemView) {
            super(itemView);

            tv_source = itemView.findViewById(R.id.tv_source);
            tv_title = itemView.findViewById(R.id.tv_title);
            tv_description = itemView.findViewById(R.id.tv_description);
            iv = itemView.findViewById(R.id.iv);
        }
    }
}
