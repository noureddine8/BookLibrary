package com.example.booklibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class BookActivity extends AppCompatActivity {
    private Button currentlyBtn,wantToReadBtn,alreadyReadBtn,favouritesBtn;
    private TextView titleTxt,authorTxt,pagesTxt,longDescTxt;
    private ImageView imageView;

    Book firstBook = new Book(1,
            "The Goat",
            "Guardiola",
            100,
            "Life of the goat",
            "   Messi began football at a young age and his potential was quickly seen by Barcelona. He left Newell's Old Boys' youth team in 2000 and moved with his family to Europe. They moved to Spain because Barcelona offered treatment for his growth hormone deficiency." +
                    "\n" +
                    "   He started in the 2004–05 season, and he scored his first goal on 1 May 2005 against Albacete from an assist by Ronaldinho. The goal made him a the youngest-ever scorer for the club at that time. Barcelona won La Liga that season for the first time in 6 years, and won the league for a second time in a row along with the Spanish Super Cup and UEFA Champions League in 2006. His first breakthrough season was in the 2006–07 season; he became a first team regular, by scoring a hat-trick in El Clásico. He scored 14 goals in 26 league games." +
                    "\n" +
                    "   Maybe his most successful season was the 2008–09 season. In this season, Messi scored 38 goals. In the following 2009–10 season, Messi scored 47 goals in all games. That equals to Ronaldo's (Brazilian) record total for Barcelona." +
                    "\n" +
                    "   Messi began football at a young age and his potential was quickly seen by Barcelona." +
                    "\n" +
                    "   He left Newell's Old Boys' youth team in 2000 and moved with his family to Europe. They moved to Spain because Barcelona offered treatment for his growth hormone deficiency. He started in the 2004–05 season, and he scored his first goal on 1 May 2005 against Albacete from an assist by Ronaldinho. The goal made him a the youngest-ever scorer for the club at that time. Barcelona won La Liga that season for the first time in 6 years, and won the league for a second time in a row along with the Spanish Super Cup and UEFA Champions League in 2006. His first breakthrough season was in the 2006–07 season; he became a first team regular, by scoring a hat-trick in El Clásico." +
                    "\n" +
                    "   He scored 14 goals in 26 league games. Maybe his most successful season was the 2008–09 season. In this season, Messi scored 38 goals. In the following 2009–10 season, Messi scored 47 goals in all games. That equals to Ronaldo's (Brazilian) record total for Paris.",
            "https://assetsds.cdnedge.bluemix.net/sites/default/files/styles/very_big_1/public/feature/images/messi-with-goat.jpg?itok=MWC0eIzq.png");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        intitViews();
        setData(firstBook);

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