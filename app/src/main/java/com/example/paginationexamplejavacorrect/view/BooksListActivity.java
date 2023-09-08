package com.example.paginationexamplejavacorrect.view;

import static com.example.paginationexamplejavacorrect.view.MainActivity.search_tag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.paging.PagedList;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import com.example.paginationexamplejavacorrect.R;
import com.example.paginationexamplejavacorrect.model.Books;
import com.example.paginationexamplejavacorrect.viewmodel.BooksListPagedAdapter;
import com.example.paginationexamplejavacorrect.viewmodel.BooksListViewModel;

public class BooksListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private BooksListViewModel booksListViewModel;
    private String query;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_books_list);

        Intent intent = getIntent();
        if (intent.hasExtra(search_tag)){
            query = intent.getStringExtra(search_tag);
        }
        recyclerView = findViewById(R.id.rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);
        BooksListPagedAdapter adapter = new BooksListPagedAdapter();
        booksListViewModel = ViewModelProviders.of(this).get(BooksListViewModel.class);
        booksListViewModel.setSearchQuery(query);
        booksListViewModel.getBooksPagedList().observe(this, new Observer<PagedList<Books>>() {
            @Override
            public void onChanged(PagedList<Books> books) {
                adapter.submitList(books);
            }
        });
        recyclerView.setAdapter(adapter);
    }
}