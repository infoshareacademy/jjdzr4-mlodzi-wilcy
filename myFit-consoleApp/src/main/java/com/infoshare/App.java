package com.infoshare;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class App {
    public static void main(String[] args) {
        System.out.println("myFit app :)");

        DummyUser dummyUser = new DummyUser();
        Gson gson = new Gson();

        FileWriter firstFile = null;
        try {
            firstFile = new FileWriter("src/main/resources/dummy.json");
            gson.toJson(dummyUser, firstFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileWriter secondFile = null;
        try {
            secondFile = new FileWriter("src/main/resources/123.json");
            gson.toJson(123.45, secondFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (Writer writer = new FileWriter("src/main/resources/dummy2.json")) {
            gson.toJson(dummyUser, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
        Interface anInterface = new Interface();
        anInterface.defaultInterface();
    }
}
