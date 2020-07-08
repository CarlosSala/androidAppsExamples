package com.example.moviesapp.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.moviesapp.model.Movie;
import com.example.moviesapp.model.MovieAdapter;
import com.example.moviesapp.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    RecyclerView recyclerView;
    ArrayList<Movie> list;
    private RequestQueue mRequestQueue;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);
        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);

        recyclerView = root.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);

        mRequestQueue = Volley.newRequestQueue(getContext());

        list = new ArrayList<>();

        parseJSON();
       /* final TextView textView = root.findViewById(R.id.text_dashboard);
        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });*/
        return root;


    }


    private void parseJSON() {

        String url = "http://newsapi.org/v2/top-headlines?country=us&apiKey=9369b6202c6747d28b9913b27afc3e47";

        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray = response.getJSONArray("articles");

                            for (int i = 0; i < jsonArray.length(); i++) {

                                JSONObject hit = jsonArray.getJSONObject(i);

                                JSONObject source = hit.getJSONObject("source");
                                Movie.Source source1 = new Movie.Source(source.getString("name"));

                                String title = hit.getString("title");
                                String description = hit.getString("description");
                                String imgUrl = hit.getString("urlToImage");

                                list.add(new Movie(source1, title, description, imgUrl));
                            }

                            MovieAdapter movieAdapter = new MovieAdapter(list);
                            recyclerView.setAdapter(movieAdapter);

                            //  mExampleAdapter1.setOnItemClickListener(MainActivity1.this);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        mRequestQueue.add(request);
    }
}