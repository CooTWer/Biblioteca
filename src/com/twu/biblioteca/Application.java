package com.twu.biblioteca;


import static com.twu.biblioteca.Handle.getConsoleMessage;

public class Application {


    public static void main(String args[]){
        Welcome welcome = new Welcome();
        System.out.println(welcome.SayWelcome());
        BookStore bookStore = new BookStore();
        System.out.println(bookStore.displayMenu());
        String str = getConsoleMessage();
        while (!str.equals("Quit")){
            String str2 = bookStore.handleInputMessage(str);
            System.out.println(str2);
            System.out.println(bookStore.displayMenu());
            str = getConsoleMessage();
        }
    }
}
