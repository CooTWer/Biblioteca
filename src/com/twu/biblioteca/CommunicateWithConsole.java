package com.twu.biblioteca;


import static com.twu.biblioteca.Handle.getConsoleMessage;

public class CommunicateWithConsole {

    public String printRequestForCheckOutBookName(){
        System.out.println("Please enter the book you want to check out!");
        return getConsoleMessage();
    }

    public String printRequestForReturnBookName(){
        System.out.println("Please enter the book you want to return");
        return getConsoleMessage();
    }
    public void printFunctionNotComplete(){
        System.out.println("Function hasn't finished!");
    }

    public void printReturnSuccess(){
        System.out.println("Thank you for returning the book.");
    }

    public void printReturnFailure(){
        System.out.println("That is not a valid book to return.");
    }
}
