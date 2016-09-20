package com.twu.biblioteca;



public class main {


    public static void main(String args[]){
        BookStore bookStore = new BookStore();
        Welcome welcome = new Welcome();
        System.out.println(welcome.SayWelcome());
        System.out.println(bookStore.menu());
    }
}
