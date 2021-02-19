package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button allBooksBtn,currentBtn,alreadyBtn,favouriteBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        allBooksBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AllBooks.class);
                startActivity(intent);
            }
        });
        Utils.getInstance();
        currentBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,CurrentlyReading.class);
                startActivity(intent);
            }
        });
        alreadyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,AlreadyRead.class);
                startActivity(intent);
            }
        });
        favouriteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,Favourites.class);
                startActivity(intent);
            }
        });
    }

    private void initViews() {
        allBooksBtn = findViewById(R.id.firstBtnId);
        currentBtn = findViewById(R.id.secondBtnId);
        alreadyBtn = findViewById(R.id.thirdBtnId);
        favouriteBtn = findViewById(R.id.fourthBtnId);

    }
}