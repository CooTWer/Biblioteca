package com.twu.biblioteca;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


public class BookStore {
    private String jsonBookList = "";
    private String bookList = "";


    public String printBookList(String jsonbooklist) {
        JSONArray jsonArray = JSONArray.fromObject(jsonbooklist);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            bookList += jsonObject.get("book_name") + "|" + jsonObject.get("Author") + "|" + jsonObject.get("Time");
            bookList += "\n";
        }
        return bookList;
    }
}
