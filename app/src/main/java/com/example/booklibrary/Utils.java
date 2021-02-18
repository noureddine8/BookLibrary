package com.example.booklibrary;

import java.util.ArrayList;

public class Utils {

    private static Utils instance;

    private static ArrayList<Book> allBooks;
    private static ArrayList<Book> currentlyReading;
    private static ArrayList<Book> alreadyRead;
    private static ArrayList<Book> favourites;

    public Utils() {
        if(allBooks == null){
            allBooks = new ArrayList<>();
            initData();
        }
        if(currentlyReading == null){
            currentlyReading = new ArrayList<>();
        }
        if(alreadyRead == null){
            alreadyRead = new ArrayList<>();
        }
        if(favourites == null){
            favourites = new ArrayList<>();
        }
    }

    private void initData() {
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
        allBooks.add(firstBook);
        allBooks.add(secondBook);
    }

    public static Utils getInstance() {
        if(instance != null){
            return instance;
        }
        else{
            instance = new Utils();
            return instance;
        }
    }

    public static ArrayList<Book> getAllBooks() {
        return allBooks;
    }

    public static ArrayList<Book> getCurrentlyReading() {
        return currentlyReading;
    }

    public static ArrayList<Book> getAlreadyRead() {
        return alreadyRead;
    }

    public static ArrayList<Book> getFavourites() {
        return favourites;
    }

    public Book getBookById(int id){
        for(Book b:allBooks){
            if(b.getId()==id){
                return b;
            }
        }
        return null;

    }

    public boolean addToCurrentlyReading(Book book){
        return currentlyReading.add(book);
    }

}
