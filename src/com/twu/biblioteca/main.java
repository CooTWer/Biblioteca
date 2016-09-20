package com.twu.biblioteca;


public class main {
    public static void main(String args[]){
        BookStore bookStore = new BookStore();
        Welcome welcome = new Welcome();
        String resourcePath = main.class.getResource("../../../").getPath() + "../src_resource/booklist.json";

        System.out.println(welcome.SayWelcome());
        System.out.print(bookStore.printBookList(bookStore.readJsonFile(resourcePath)));
    }
}
