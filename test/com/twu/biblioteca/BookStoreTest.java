package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookStoreTest {
    private BookStore bookStore = new BookStore();


    @Test
    public void printBookListWithMultiData() {
        String expect = "book1|ZhangSan|2015-04-06\nbook2|LiSi|2012-02-01\nbook3|WangWu|2010-01-15\n";
        String actual = bookStore.printBookList();
        assertEquals(expect, actual);
    }

    @Test
    public void menu(){
        String expect = "[List Books]\t[Recent History]\t[Sign in]\t[Quit]";
        String actual = bookStore.displayMenu();
        assertEquals(expect,actual);
    }

    @Test
    public void optionValidWrongCheck(){
        assertFalse(bookStore.optionValidCheck("error"));
    }

    @Test
    public void optionValidNullCheck(){
        assertFalse(bookStore.optionValidCheck(""));
    }

    @Test
    public void optionValidSpaceCheck(){
        assertFalse(bookStore.optionValidCheck(" "));
    }

    @Test
    public void optionValidCorrectCheck(){
        assertFalse(bookStore.optionValidCheck("Books List"));
    }

    @Test
    public void handleInputMessage(){
        String expect = "Select a valid option!";
        String actual = bookStore.handleInputMessage("error");
        assertEquals(expect,actual);
    }

    @Test
    public void successCheckoutResponse(){
        String expect = "Thank you! Enjoy the book";
        String actual = bookStore.checkOutBook("book1");
        assertEquals(expect,actual);
    }

    @Test
    public void failureCheckOutResponse(){
        String expect = "That book is not available.";
        String actual = bookStore.checkOutBook("book");
        assertEquals(expect,actual);
    }

    @Test
    public void checkoutIsAvailable(){
        assertTrue(bookStore.isCheckOutAvailable("book2"));
    }

    @Test
    public void checkOutFailure(){
        assertFalse(bookStore.isCheckOutAvailable("book"));
    }

}