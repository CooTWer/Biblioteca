package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;


public class BookStoreTest {
    private BookStore bookStore = new BookStore();

    private String jsonAddressSingle = this.getClass().getResource("../../../").getPath() + "../test_resource/booklistsingle.json";
    private String jsonAddressMulti = this.getClass().getResource("../../../").getPath() + "../test_resource/booklistmulti.json";

    private String jsonStringSingle = "[  {    \"book_name\": \"book1\"  }]";
    private String jsonStringMulti = "[  {    \"book_name\": \"book1\"  },  {    \"book_name\": \"book2\"  }]";

    @Test
    public void readJsonFileWithSingleData() {
        assertEquals("[  {    \"book_name\": \"book1\"  }]", bookStore.readJsonFile(jsonAddressSingle));
    }

    @Test
    public void readJsonFileWithMultiData() {
        assertEquals("[  {    \"book_name\": \"book1\"  },  {    \"book_name\": \"book2\"  }]", bookStore.readJsonFile(jsonAddressMulti));
    }

    @Test
    public void printBookListWithSingleData() {
        assertEquals("book1\n", bookStore.printBookList(jsonStringSingle));
    }

    @Test
    public void printBookListWithMultiData() {
        assertEquals("book1\nbook2\n", bookStore.printBookList(jsonStringMulti));
    }
}