package com.infoshare.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.infoshare.ProductsDataBase;

import java.io.*;
import java.util.ArrayList;

public class FoodDataBase {
    public static ArrayList<ProductsDataBase> foodData = new ArrayList<>();


    public static void saveToFile() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("src/main/resources/foodData.json")) {
            gson.toJson(foodData, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file");
        }
    }

    public static void loadFromFile() {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader("src/main/resources/foodData.json");
            foodData = gson.fromJson(reader, new TypeToken<ArrayList<ProductsDataBase>>() {
            }.getType());
        } catch (FileNotFoundException e) {
            System.out.println("Add your first meal.");
        }
    }
}

