package com.twu.biblioteca;


import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class handle {
    public static String jsonBookList = "";

    public static String readJsonFile(String jsonAddress){
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
}
