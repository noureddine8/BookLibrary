package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class AllBooks extends AppCompatActivity {
    private RecyclerView booksRecyclerView;
    private BookRecyclerViewAdapter adapter;
    private List<Book> books;
    Book firstBook = new Book(1,
            "The Goat",
            "Guardiola",
            100,
            "Life of the goat",
            "The greatest of all time",
            "https://assetsds.cdnedge.bluemix.net/sites/default/files/styles/very_big_1/public/feature/images/messi-with-goat.jpg?itok=MWC0eIzq.png");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        books = new ArrayList<>();

        books.add(firstBook);
        booksRecyclerView = findViewById(R.id.booksRecyclerId);

        adapter = new BookRecyclerViewAdapter(this);
        adapter.setBooks(books);
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new GridLayoutManager(this,2));
    }
}