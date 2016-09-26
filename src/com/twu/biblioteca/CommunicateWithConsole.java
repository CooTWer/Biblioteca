package com.twu.biblioteca;


import static com.twu.biblioteca.BookStore.menuMessage;
import static com.twu.biblioteca.UniversalUtilities.getConsoleMessage;

public class CommunicateWithConsole {


    public void printWelcome() {
        System.out.println("Welcome to Bangalore Public Library");
    }

    public void printBookStoreMenu() {
        System.out.println(menuMessage);
    }

    public String printRequestForCheckOutBookName() {
        System.out.println("Please enter the book you want to check out!");
        return getConsoleMessage();
    }

    public String printRequestForCheckOutMovieName() {
        System.out.println("Please enter the movie you want to check out!");
        return getConsoleMessage();
    }

    public String printRequestForReturnBookName() {
        System.out.println("Please enter the book you want to return");
        return getConsoleMessage();
    }

    public void printFunctionNotComplete() {
        System.out.println("Function hasn't finished!");
    }


    public void interactiveFunction(BookStore bookStore) {
        String inputString = getConsoleMessage();
        while (!inputString.equals("Quit")) {
            System.out.println(bookStore.handleInputMessage(inputString));
            bookStore.displayMenu();
            inputString = getConsoleMessage();
        }
    }

    public String printRequestForUserId() {
        System.out.println("Please input your Id!");
        return getConsoleMessage();
    }

    public String printRequestForUserPwd(){
        System.out.println("Please input your PassWord!");
        return getConsoleMessage();
    }
}
