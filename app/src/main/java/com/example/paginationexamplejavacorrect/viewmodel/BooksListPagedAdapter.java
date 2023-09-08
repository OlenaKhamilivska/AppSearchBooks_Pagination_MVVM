package com.example.paginationexamplejavacorrect.viewmodel;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.paging.PagedListAdapter;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.paginationexamplejavacorrect.R;
import com.example.paginationexamplejavacorrect.model.Books;
import com.squareup.picasso.Picasso;

public class BooksListPagedAdapter extends PagedListAdapter<Books, BooksListPagedAdapter.BooksListViewHolder> {

    public BooksListPagedAdapter() {
        super(diffCallback);
    }

    @NonNull
    @Override
    public BooksListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.books_list_item, parent, false);

        return new BooksListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksListViewHolder holder, int position) {
        Books book = getItem(position);
        if (book != null){
            holder.book_titleTV.setText(book.getTitle());
            holder.book_isbnTV.setText(book.getIsbn13());
            holder.book_priceTV.setText(book.getPrice());

            Picasso.get().load(book.getImage()).placeholder(R.drawable.loading).into(holder.image_IV);
        }

    }

    private static DiffUtil.ItemCallback<Books> diffCallback = new DiffUtil.ItemCallback<Books>() {
        @Override
        public boolean areItemsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
            return oldItem.getIsbn13() == newItem.getIsbn13();
        }

        @Override
        public boolean areContentsTheSame(@NonNull Books oldItem, @NonNull Books newItem) {
            return oldItem.equals(newItem);
        }
    };

    class BooksListViewHolder extends RecyclerView.ViewHolder{

        private TextView book_titleTV, book_isbnTV, book_priceTV;
        private ImageView image_IV;

        public BooksListViewHolder(@NonNull View itemView) {
            super(itemView);
            book_titleTV = itemView.findViewById(R.id.book_titleTV);
            book_isbnTV = itemView.findViewById(R.id.book_isbnTV);
            book_priceTV = itemView.findViewById(R.id.book_priceTV);
            image_IV = itemView.findViewById(R.id.image_IV);
        }
    }
}
