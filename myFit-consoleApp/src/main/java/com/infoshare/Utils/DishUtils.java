package com.infoshare.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.DishDataBase;

import java.io.*;
import java.util.ArrayList;

public class DishUtils {
    public static ArrayList<DishDataBase> dishDataBaseArrayList = new ArrayList<>();


    public static void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("src/main/resources/dishData.json")) {
            gson.toJson(dishDataBaseArrayList, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file");
        }
    }

    public static void loadFromFile() {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader("src/main/resources/dishData.json");
            dishDataBaseArrayList = gson.fromJson(reader, new TypeToken<ArrayList<DishDataBase>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            System.out.println("and add your first meal.");
        }
    }
}