package com.example.retrofittutorial.Interface;

import com.example.retrofittutorial.models.Response;
import com.example.retrofittutorial.models.Posts;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;


public interface JsonPlaceHolderApi2 {

    // endpoints "posts"
    @GET("posts")
    Call<List<Posts>> getPosts();

    @GET("usersFake")
     Call<List<Response>> getUsersFake();

    @POST("usersFake")
    Call<List<Response>> postUsersFake();
}
