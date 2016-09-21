package com.twu.biblioteca;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import static com.twu.biblioteca.Handle.readJsonFile;


public class BookStore {
    private String bookList = "";
    private static String menuMessage = "";
    private String resourcePath = this.getClass().getResource("../../../").getPath() + "../src_resource/booklist.json";

    public String printBookList(String jsonBookList) {
        JSONArray jsonArray = JSONArray.fromObject(jsonBookList);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            bookList += jsonObject.get("book_name") + "|" + jsonObject.get("Author") + "|" + jsonObject.get("Time");
            bookList += "\n";
        }
        return bookList;
    }

    public String menu() {
        menuMessage = "[List Books]\t[Recent History]\t[Sign in]\t[Quit]";
        return menuMessage;
    }

    public boolean optionValidCheck(String inputOption) {
        boolean isValid = true;
        if (menuMessage.indexOf(inputOption) == -1 || inputOption.equals("")) {
            isValid = false;
        }
        return isValid;
    }

    public String handleInputMessage(String inputOption) {
        if (this.optionValidCheck(inputOption)) {
            return this.printBookList(readJsonFile(resourcePath));
        } else {
            return "Select a valid option!";
        }
    }
}
