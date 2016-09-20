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
        assertEquals("book1|ZhangSan|2015-06-06\nbook2|LiSi|2016-11-15\n", bookStore.printBookList(jsonStringMulti));
    }
}