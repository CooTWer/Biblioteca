package com.twu.biblioteca;


public class Application {


    public static void main(String args[]) {
        BookStore bookStore = new BookStore();
        bookStore.sayWelcome();
        bookStore.displayMenu();
        new CommunicateWithConsole().interactiveFunction(bookStore);
    }
}
