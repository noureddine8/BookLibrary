package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import static com.example.booklibrary.BookRecyclerViewAdapter.BOOK_ID_KEY;

public class BookActivity extends AppCompatActivity {
    private Button currentlyBtn, wantToReadBtn, alreadyReadBtn, favouritesBtn;
    private TextView titleTxt, authorTxt, pagesTxt, longDescTxt;
    private ImageView imageView;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        intitViews();
        intent = getIntent();
        if (intent != null) {
            int bookId = intent.getIntExtra(BOOK_ID_KEY, -1);
            Book incomingBook = Utils.getInstance().getBookById(bookId);
            if (incomingBook != null) {
                setData(incomingBook);
                handleCurrentlyReading(incomingBook);
            }
        }

    }

    private void handleCurrentlyReading(Book incomingBook) {
        ArrayList<Book> currentlyReading = Utils.getInstance().getCurrentlyReading();
        boolean existInCurrently = false;
        for(Book b:currentlyReading) {
            if (b.getId() == incomingBook.getId()) {
                existInCurrently = true;
            }
        }
            if(existInCurrently){
                currentlyBtn.setEnabled(false);
            }
            else{
                currentlyBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(Utils.getInstance().addToCurrentlyReading(incomingBook)){
                            Toast.makeText(BookActivity.this, "Book added to currently Reading", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(BookActivity.this,CurrentlyReading.class);
                            startActivity(intent);
                        }
                        else {
                            Toast.makeText(BookActivity.this, "A problem has occured", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }


    private void setData(Book book) {
        titleTxt.setText(book.getTitle());
        authorTxt.setText(book.getAuthor());
        pagesTxt.setText(String.valueOf(book.getPages()));
        longDescTxt.setText(book.getLongDesc());
        Glide.with(this).asBitmap().load(book.getImageUrl()).into(imageView);

    }

    private void intitViews() {
        //Buttons
        currentlyBtn = findViewById(R.id.currentlyReadingId);
        wantToReadBtn = findViewById(R.id.wantToReadId);
        alreadyReadBtn = findViewById(R.id.alredayReadId);
        favouritesBtn = findViewById(R.id.favouriteId);

        //TextViews
        titleTxt = findViewById(R.id.bookTitleId);
        authorTxt = findViewById(R.id.bookAuthorId);
        pagesTxt = findViewById(R.id.bookPagesId);
        longDescTxt = findViewById(R.id.bookLongDescId);

        //ImageView
        imageView = findViewById(R.id.imageBookId);


    }
}