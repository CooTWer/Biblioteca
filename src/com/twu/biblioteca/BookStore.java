package com.twu.biblioteca;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class BookStore {
    private String jsonBookList = "";
    private String bookList = "";
    private String jsonAddress = "";

    public String readJsonFile(String jsonAddress){
        BufferedReader reader = null;
        try {
            FileInputStream fileInputStream = new FileInputStream(jsonAddress);
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
            reader = new BufferedReader(inputStreamReader);
            String tempString = null;
            while ((tempString = reader.readLine()) != null){
                jsonBookList += tempString;
            }
            reader.close();
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            if (reader != null){
                try{
                    reader.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
        return jsonBookList;
    }

    public String printBookList(String jsonbooklist){
        JSONArray jsonArray = JSONArray.fromObject(jsonbooklist);
        for (int i=0; i<jsonArray.size(); i++){
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            bookList += jsonObject.get("book_name");
            bookList += "\n";
        }
        return bookList;
    }
}
