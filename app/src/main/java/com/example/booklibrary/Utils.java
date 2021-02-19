package com.example.booklibrary;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static final String ALL_BOOK_KEY = "all_books";
    public static final String CURRENTLY_READING = "currently_reading";
    public static final String ALREADY_READ = "already_read";
    public static final String FAVOURITES = "favourites";


    private static Utils instance;

    private SharedPreferences sharedPreferences;


    public Utils(Context context) {

        sharedPreferences = context.getSharedPreferences("alternateDb", Context.MODE_PRIVATE);

        if (getAllBooks() == null) {
            initData();
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();

        if (getSectionBooks(CURRENTLY_READING) == null) {
            editor.putString(CURRENTLY_READING, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (getSectionBooks(ALREADY_READ) == null) {
            editor.putString(ALREADY_READ, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
        if (getSectionBooks(FAVOURITES) == null) {
            editor.putString(FAVOURITES, gson.toJson(new ArrayList<Book>()));
            editor.commit();
        }
    }

    private void initData() {
        List<Book> books = new ArrayList<>();
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
        books.add(firstBook);
        books.add(secondBook);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String stringifiedBooks = gson.toJson(books);
        editor.putString(ALL_BOOK_KEY, stringifiedBooks);
        editor.commit();
    }

    public static Utils getInstance(Context context) {
        if (instance != null) {
            return instance;
        } else {
            instance = new Utils(context);
            return instance;
        }
    }

    public ArrayList<Book> getAllBooks() {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(ALL_BOOK_KEY, null), type);
        return books;
    }

    public ArrayList<Book> getSectionBooks(String key) {
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<Book>>() {
        }.getType();
        ArrayList<Book> books = gson.fromJson(sharedPreferences.getString(key, null), type);
        return books;
    }

    public Book getBookById(int id) {
        ArrayList<Book> books = getAllBooks();
        if (books != null) {
            for (Book b : books) {
                if (b.getId() == id) {
                    return b;
                }
            }
        }
        return null;
    }

    public boolean addToSection(String key, Book book) {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ArrayList<Book> books = getSectionBooks(key);
        if(book !=null){
            if(books.add(book)){
                editor.remove(key);
                editor.putString(key,gson.toJson(books));
                editor.commit();
                return true;
            }
        }

        return false;
    }

    public boolean removeFromSection(String key, Book book) {
        Gson gson = new Gson();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        ArrayList<Book> books = getSectionBooks(key);
        if(book !=null){
            for(Book b:books){
                if(book.getId() == b.getId()){
                    if(books.remove(b)){
                        editor.remove(key);
                        editor.putString(key,gson.toJson(books));
                        editor.commit();
                        return true;
                    }
                }
            }

        }

        return false;
    }

}
