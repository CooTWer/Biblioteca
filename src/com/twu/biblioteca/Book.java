package com.twu.biblioteca;

public class Book {
    public String name;
    public String author;
    public String date;
    public boolean available;

    public Book(String name, String author, String date) {
        this.name = name;
        this.author = author;
        this.date = date;
        this.available = true;
    }
}
