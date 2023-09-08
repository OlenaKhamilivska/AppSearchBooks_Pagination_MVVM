package com.example.paginationexamplejavacorrect.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PageKeyedDataSource;
import androidx.paging.PagedList;

import com.example.paginationexamplejavacorrect.model.QueryPOJO;
import com.example.paginationexamplejavacorrect.model.BooksDataSourceFactory;
import com.example.paginationexamplejavacorrect.model.Books;

public class BooksListViewModel extends ViewModel {

    private LiveData<PagedList<Books>> booksPagedList;
    private LiveData<PageKeyedDataSource<Integer, Books>> liveDataSource;
    private QueryPOJO queryPOJO;

    public BooksListViewModel() {
        BooksDataSourceFactory dataSourceFactory = new BooksDataSourceFactory();
        liveDataSource = dataSourceFactory.getBooksLiveData();
        PagedList.Config config = new PagedList.Config.Builder()
                .setEnablePlaceholders(true)
                .setPageSize(5)
                .build();
        booksPagedList = new LivePagedListBuilder(dataSourceFactory, config)
                .build();

    }

    public LiveData<PagedList<Books>> getBooksPagedList() {
        return booksPagedList;
    }

    public void setSearchQuery(String searchQuery) {
        queryPOJO = new QueryPOJO();
        queryPOJO.setSearchQueryString(searchQuery);
    }
}
