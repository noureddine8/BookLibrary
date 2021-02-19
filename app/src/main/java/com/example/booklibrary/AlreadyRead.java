package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

public class AlreadyRead extends AppCompatActivity {
    private RecyclerView alreadyRead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_already_read);
        alreadyRead = findViewById(R.id.alreadyReadLayoutId);
        BookRecyclerViewAdapter adapter = new BookRecyclerViewAdapter(this);
        alreadyRead.setAdapter(adapter);
        alreadyRead.setLayoutManager(new LinearLayoutManager(this));
        adapter.setBooks(Utils.getAlreadyRead());

    }
    @Override
    public void onBackPressed() {
        Intent intent = new Intent(this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
}