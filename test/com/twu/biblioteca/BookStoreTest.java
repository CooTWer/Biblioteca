package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookStoreTest {
    private BookStore bookStore = new BookStore();

    private String jsonStringSingle = "[  {    \"book_name\": \"book1\",  \"Author\": \"ZhangSan\",\"Time\": \"2015-06-06\"} ]";
    private String jsonStringMulti = "[  {    \"book_name\": \"book1\",  \"Author\": \"ZhangSan\",\"Time\": \"2015-06-06\"  },  {    \"book_name\": \"book2\",  \"Author\": \"LiSi\",\"Time\": \"2016-11-15\"  }]";


    @Test
    public void printBookListWithSingleData() {
        assertEquals("book1|ZhangSan|2015-06-06\n", bookStore.printBookList(jsonStringSingle));
    }

    @Test
    public void printBookListWithMultiData() {
        String expect = "book1|ZhangSan|2015-06-06\nbook2|LiSi|2016-11-15\n";
        String actual = bookStore.printBookList(jsonStringMulti);
        assertEquals(expect, actual);
    }

    @Test
    public void menu(){
        String expect = "[List Books]\t[Recent History]\t[Sign in]\t[Quit]";
        String actual = bookStore.menu();
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



}