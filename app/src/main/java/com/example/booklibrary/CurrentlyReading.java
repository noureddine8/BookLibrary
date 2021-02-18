package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class CurrentlyReading extends AppCompatActivity {
    private RecyclerView currentlyReading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        currentlyReading = findViewById(R.id.currentlyReadingLayoutId);
        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(this);
        currentlyReading.setAdapter(adapter);
        currentlyReading.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getCurrentlyReading());

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}