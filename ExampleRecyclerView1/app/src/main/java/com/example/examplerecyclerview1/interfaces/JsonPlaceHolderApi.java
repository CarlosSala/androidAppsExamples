package com.example.examplerecyclerview1.interfaces;

import com.example.examplerecyclerview1.model.ExampleItem;
import com.google.gson.JsonObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true")
    Call<JsonObject> getItems();
}
