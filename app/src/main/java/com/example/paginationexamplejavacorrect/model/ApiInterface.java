package com.example.paginationexamplejavacorrect.model;

import com.example.paginationexamplejavacorrect.model.response_pojo.BooksApiResponce;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ApiInterface {

    @GET("search/{query}/{page}")
    Call<BooksApiResponce> getProgrammingBooks(
            @Path("query") String query,
            @Path("page") int page
    );
}
