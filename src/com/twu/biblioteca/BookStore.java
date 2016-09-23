package com.twu.biblioteca;


import com.twu.biblioteca.movie.Movie;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.twu.biblioteca.UniversalUtilities.readJsonFile;


public class BookStore {
    public static ArrayList<Book> books = new ArrayList<>();
    public static Map<String, Movie> movies = new HashMap<>();
    public static String menuMessage = "[List Books]\t[List Movies]\t[Return Book]\t[Sign in]\t[Check Out Book]\t[Check Out Movie]\t[Quit]";

    private String bookList;
    private String resourcePathBooks;
    private String resourcePathMovies;
    private int checkOutBookPositionInBooks;
    private CommunicateWithConsole communicateWithConsole;

    public BookStore() {
        this.bookList = "";
        this.resourcePathBooks = this.getClass().getResource("../../../").getPath() + "../src_resource/booklist.json";
        this.resourcePathMovies = this.getClass().getResource("../../../").getPath() + "../src_resource/movielist.json";
        this.communicateWithConsole = new CommunicateWithConsole();
        this.loadBooks(readJsonFile(resourcePathBooks));
        this.loadMovies(readJsonFile(resourcePathMovies));
    }

    public void sayWelcome() {
        communicateWithConsole.printWelcome();
    }

    public void loadBooks(String jsonBookList) {
        books.clear();
        JSONArray jsonArray = JSONArray.fromObject(jsonBookList);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Book book = new Book(jsonObject.get("book_name").toString(), jsonObject.get("Author").toString(), jsonObject.get("Time").toString());
            books.add(book);
        }
    }

    public void loadMovies(String jsonMoviesList) {
        movies.clear();
        JSONArray jsonArray = JSONArray.fromObject(jsonMoviesList);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            Movie movie = new Movie(jsonObject.get("name").toString(), jsonObject.get("year").toString(), jsonObject.get("director").toString(), Integer.parseInt(String.valueOf(jsonObject.get("rate"))));
            movies.put(jsonObject.get("rate").toString(), movie);
        }
    }

    public String printBookList() {
        bookList = "";
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).available)
                bookList += books.get(i).name + "|" + books.get(i).author + "|" + books.get(i).date + "\n";
        }
        return bookList;
    }

    public String printMovieList() {
        String movieList = "";
        List<Map.Entry<String, Movie>> list = this.rankMoviesByRate(movies);

        for (Map.Entry<String, Movie> mapping : list ) {
            Movie tempMovie = mapping.getValue();
            if(tempMovie.getAvailable())
                movieList += tempMovie.getRate() + "|" + tempMovie.getName() + "|" + tempMovie.getDirector() + "|" + tempMovie.getYear() + "\n";
        }
        return movieList;
    }

    public List rankMoviesByRate(Map<String, Movie> movieMap) {
        List<Map.Entry<String, Movie>> list = new ArrayList<>(movieMap.entrySet());
        return list;
    }

    public void displayMenu() {
        communicateWithConsole.printBookStoreMenu();
    }

    public boolean optionValidCheck(String inputOption) {
        boolean isValid = true;
        if (menuMessage.indexOf(inputOption) == -1 || inputOption.equals("") || inputOption.equals(" ")) {
            isValid = false;
        }
        return isValid;
    }

    public String handleInputMessage(String inputOption) {
        if (this.optionValidCheck(inputOption)) {
            switch (inputOption) {
                case "List Books":
                    return this.printBookList();
                case "Check Out Book":
                    return this.checkOutBook(communicateWithConsole.printRequestForCheckOutBookName());
                case "Return Book":
                    return this.returnBook(communicateWithConsole.printRequestForReturnBookName());
                case "List Movies":
                    return this.printMovieList();
                case "Check Out Movie":
                    return this.checkOutMovie(communicateWithConsole.printRequestForCheckOutMovieName());
                default:
                    communicateWithConsole.printFunctionNotComplete();
                    return null;
            }
        } else {
            return "Select a valid option!";
        }
    }

    public String checkOutBook(String book) {
        if (isCheckOutBookAvailable(book)) {
            books.get(this.checkOutBookPositionInBooks).available = false;
            return "Thank you! Enjoy the book";
        } else {
            return "That book is not available.";
        }
    }


    public boolean isCheckOutBookAvailable(String book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).name.equals(book) && books.get(i).available) {
                this.checkOutBookPositionInBooks = i;
                return true;
            }
        }
        return false;
    }

    public String checkOutMovie(String movie) {
        if (isCheckOutMovieAvailable(movie)) {
            return "Thank you! Enjoy the movie";
        } else {
            return "That movie is not available.";
        }
    }

    public boolean isCheckOutMovieAvailable(String movie) {
        for (Movie entry : movies.values()) {
            String aa = entry.getName();
            boolean k = entry.getAvailable();
            if (entry.getName().equals(movie) && entry.getAvailable()) {
                entry.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean isReturnAvailable(String book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).name.equals(book) && !books.get(i).available) {
                books.get(i).available = true;
                return true;
            }
        }
        return false;
    }

    public String returnBook(String book) {
        if (this.isReturnAvailable(book))
            return "Thank you for returning the book.";
        else
            return "That is not a valid book to return.";
    }
}
