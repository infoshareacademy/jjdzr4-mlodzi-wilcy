package com.infoshare.Utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.infoshare.UserLoginData;

import java.io.*;
import java.util.ArrayList;

public class UserDataBase {
    public static ArrayList<UserLoginData> loginData = new ArrayList<>();

    public static void saveToFile() {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter("src/main/resources/loginData.json")) {
            gson.toJson(loginData, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file");
        }
    }

    public static void loadFromFile() {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader("src/main/resources/loginData.json");
            loginData = gson.fromJson(reader, new TypeToken<ArrayList<UserLoginData>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            System.out.println("You are our first user, have a great time!");
        }
    }


}
