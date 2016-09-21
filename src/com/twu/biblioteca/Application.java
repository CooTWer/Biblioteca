package com.twu.biblioteca;


import static com.twu.biblioteca.Handle.getConsoleMessage;

public class Application {


    public static void main(String args[]){
        BookStore bookStore = new BookStore();
        Welcome welcome = new Welcome();
        System.out.println(welcome.SayWelcome());
        System.out.println(bookStore.menu());
        System.out.println(bookStore.handleInputMessage(getConsoleMessage()));
    }
}
