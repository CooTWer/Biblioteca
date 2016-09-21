package com.twu.biblioteca;


import static com.twu.biblioteca.Handle.getConsoleMessage;

public class CommunicateWithConsole {

    public String printAskForBookName(){
        System.out.println("Please enter the book you want to check out!");
        return getConsoleMessage();
    }

    public void printFunctionNotComplete(){
        System.out.println("Function hasn't finished!");
    }
}
