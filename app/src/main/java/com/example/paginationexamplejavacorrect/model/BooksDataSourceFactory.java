package com.example.paginationexamplejavacorrect.model;

import androidx.lifecycle.MutableLiveData;
import androidx.paging.DataSource;
import androidx.paging.PageKeyedDataSource;

import com.example.paginationexamplejavacorrect.model.dataSource.BooksDataSource;

public class BooksDataSourceFactory extends DataSource.Factory {

    MutableLiveData<PageKeyedDataSource<Integer, Books>> booksLiveData =
            new MutableLiveData<>();

    @Override
    public DataSource create() {
        BooksDataSource booksDataSource = new BooksDataSource();
        booksLiveData.postValue(booksDataSource);
        return booksDataSource;
    }

    public MutableLiveData<PageKeyedDataSource<Integer, Books>> getBooksLiveData() {
        return booksLiveData;
    }
}
