package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
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
    Book secondBook = new Book(2,
            "Harry Potter",
            "J.K.Rowling",
            2000,
            "The greatest wizard",
            "Life of Harry Potter vs Dark Lord",
            "https://m.media-amazon.com/images/M/MV5BNjQ3NWNlNmQtMTE5ZS00MDdmLTlkZjUtZTBlM2UxMGFiMTU3XkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_UY1200_CR90,0,630,1200_AL_.jpg");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_books);
        books = new ArrayList<>();

        books.add(firstBook);
        books.add(secondBook);
        booksRecyclerView = findViewById(R.id.booksRecyclerId);

        adapter = new BookRecyclerViewAdapter(this);
        adapter.setBooks(books);
        booksRecyclerView.setAdapter(adapter);
        booksRecyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}