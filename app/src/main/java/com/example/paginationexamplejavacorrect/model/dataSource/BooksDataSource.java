package com.example.paginationexamplejavacorrect.model.dataSource;

import androidx.annotation.NonNull;
import androidx.paging.PageKeyedDataSource;

import com.example.paginationexamplejavacorrect.model.QueryPOJO;
import com.example.paginationexamplejavacorrect.model.ApiClient;
import com.example.paginationexamplejavacorrect.model.Books;
import com.example.paginationexamplejavacorrect.model.response_pojo.BooksApiResponce;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BooksDataSource extends PageKeyedDataSource<Integer, Books> {

    public static final int first_image = 1;
    private QueryPOJO queryPOJO;

    @Override
    public void loadInitial(@NonNull LoadInitialParams<Integer> params, @NonNull LoadInitialCallback<Integer, Books> callback) {
        queryPOJO = new QueryPOJO();
        ApiClient.getApiClient().getApiInterface().getProgrammingBooks(queryPOJO.getSearchQueryString(), first_image)
                .enqueue(new Callback<BooksApiResponce>() {
                    @Override
                    public void onResponse(Call<BooksApiResponce> call, Response<BooksApiResponce> response) {
                        if (response != null) {
                            callback.onResult(response.body().getBooks(), null, first_image+1);
                        }
                    }
                    @Override
                    public void onFailure(Call<BooksApiResponce> call, Throwable t) {
                    }
                });
    }

    @Override
    public void loadBefore(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer,
            Books> callback) {
    }
    @Override
    public void loadAfter(@NonNull LoadParams<Integer> params, @NonNull LoadCallback<Integer, Books> callback) {
        ApiClient.getApiClient().getApiInterface().getProgrammingBooks(queryPOJO.getSearchQueryString(), first_image)
                .enqueue(new Callback<BooksApiResponce>() {
                    @Override
                    public void onResponse(Call<BooksApiResponce> call, Response<BooksApiResponce> response) {
                        if (response != null) {
                            int key = params.key+1;
                            callback.onResult(response.body().getBooks(), key);
                        }
                    }

                    @Override
                    public void onFailure(Call<BooksApiResponce> call, Throwable t) {

                    }
                });
    }
}
