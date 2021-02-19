package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import static com.example.booklibrary.Utils.CURRENTLY_READING;

public class CurrentlyReading extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currently_reading);
        RecyclerView currentlyReading = findViewById(R.id.currentlyReadingLayoutId);
        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(this);
        currentlyReading.setAdapter(adapter);
        currentlyReading.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getInstance(this).getSectionBooks(CURRENTLY_READING));

    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}