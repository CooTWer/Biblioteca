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
    public void checkoutBookIsAvailable(){
        assertTrue(bookStore.isCheckOutBookAvailable("book2"));
    }

    @Test
    public void checkOutFailure(){
        assertFalse(bookStore.isCheckOutBookAvailable("book"));
    }

    @Test
    public void returnBookSuccess(){
        bookStore.books.get(0).available = false;
        assertTrue(bookStore.isReturnAvailable("book1"));
        bookStore.books.get(0).available = true;
    }

    @Test
    public void returnBookFailureForWrongName(){
        assertFalse(bookStore.isReturnAvailable("book5"));
    }

    @Test
    public void returnBookFailureForAvailableBook(){
        assertFalse(bookStore.isReturnAvailable("book2"));
    }
}