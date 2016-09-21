package com.twu.biblioteca;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.util.ArrayList;

import static com.twu.biblioteca.Handle.readJsonFile;


public class BookStore {
    public static ArrayList<Book> books = new ArrayList<>();
    public static String menuMessage;
    private String bookList;
    private String resourcePath;
    private int checkOutBookPositionInBooks;
    private CommunicateWithConsole communicateWithConsole;

    public BookStore() {
        this.bookList = "";
        this.resourcePath = this.getClass().getResource("../../../").getPath() + "../src_resource/booklist.json";
        this.communicateWithConsole = new CommunicateWithConsole();
        this.loadBooks(readJsonFile(resourcePath));
        this.displayMenu();
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

    public String printBookList() {
        bookList = "";
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).available)
                bookList += books.get(i).name + "|" + books.get(i).author + "|" + books.get(i).date + "\n";
        }
        return bookList;
    }

    public String displayMenu() {
        menuMessage = "[List Books]\t[Return Book]\t[Sign in]\t[Check Out]\t[Quit]";
        return menuMessage;
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
                case "Check Out":
                    return this.checkOutBook(communicateWithConsole.printRequestForCheckOutBookName());
                case "Return Book":
                    return this.returnBook(communicateWithConsole.printRequestForReturnBookName());
                default:
                    communicateWithConsole.printFunctionNotComplete();
                    return null;
            }
        } else {
            return "Select a valid option!";
        }
    }

    public String checkOutBook(String book) {
        if (isCheckOutAvailable(book)) {
            books.get(this.checkOutBookPositionInBooks).available = false;
            return "Thank you! Enjoy the book";
        } else {
            return "That book is not available.";
        }
    }

    public boolean isCheckOutAvailable(String book) {
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).name.equals(book) && books.get(i).available) {
                this.checkOutBookPositionInBooks = i;
                return true;
            }
        }
        return false;
    }

    public boolean isReturnAvailable(String book) {
        for (int i = 0; i<books.size(); i++){
            if(books.get(i).name.equals(book) && !books.get(i).available){
                books.get(i).available = true;
                return true;
            }
        }
        return false;
    }

    public String returnBook(String book){
        if(this.isReturnAvailable(book))
            return "Thank you for returning the book.";
        else
            return "That is not a valid book to return.";
    }
}
