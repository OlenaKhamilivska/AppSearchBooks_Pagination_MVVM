package com.example.paginationexamplejavacorrect.model;

import com.example.paginationexamplejavacorrect.Constans;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {
    private static ApiClient apiClient;
    private Retrofit retrofit;

    private ApiClient(){
        Gson gson = new GsonBuilder().create();

        retrofit = new retrofit2.Retrofit.Builder()
                .baseUrl(Constans.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    public static synchronized ApiClient getApiClient(){
        if (apiClient == null) {
            apiClient = new ApiClient();
        }
        return apiClient;
    }
    public ApiInterface getApiInterface(){
        return retrofit.create(ApiInterface.class);
    }
}
