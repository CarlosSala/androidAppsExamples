package com.example.codinginflowrecycler.interfaces;

import com.example.codinginflowrecycler.models.ExampleItem2;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("posts")
    Call<List<ExampleItem2>> getPosts();
}
