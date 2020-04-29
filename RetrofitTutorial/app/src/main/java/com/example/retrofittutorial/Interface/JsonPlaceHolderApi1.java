package com.example.retrofittutorial.Interface;

import com.example.retrofittutorial.models.Comments;
import com.example.retrofittutorial.models.Post;

import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface JsonPlaceHolderApi1 {

    @GET("posts")
    Call<List<Post>> getPosts();

    @GET("posts/{id}/comments")
    Call<List<Comments>> getComments(@Path("id") int postId);

    @GET
    Call<List<Comments>> getComments(@Url String url);

    @GET("posts")
    Call<List<Post>> getQueryPosts(
            @Query("userId") Integer[] userId,
            // @Query("userId") int userId2,
            @Query("_sort") String sort,
            @Query("_order") String order);

    @GET("posts")
    Call<List<Post>> getPosts2(@QueryMap Map<String, String> parameters);

    @POST("posts")
    Call<Post> createPost(@Body Post post);

    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(
            @Field("userId") int userId,
            @Field("title") String title,
            @Field("body") String text
    );


    @FormUrlEncoded
    @POST("posts")
    Call<Post> createPost(@FieldMap Map<String, String> fields);

    @PUT("posts/{id}")
    Call<Post> putPost (@Path("id") int id , @Body Post post);

    @PATCH("posts/{id}")
    Call<Post> patchPost (@Path("id") int id , @Body Post post);

    @DELETE("posts/{id}")
    Call<Void> deletePost(@Path("id") int id);

}
