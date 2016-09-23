package com.twu.biblioteca.movie;


public class Movie {
    private String name;
    private String year;
    private String director;
    private int rate;
    private boolean available;

    public Movie(String name, String year, String director, int rate) {
        this.name = name;
        this.year = year;
        this.director = director;
        this.rate = rate;
        this.available = true;
    }

    public String getName() {
        return name;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public int getRate() {
        return rate;
    }

    public boolean getAvailable() {return available;}

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
