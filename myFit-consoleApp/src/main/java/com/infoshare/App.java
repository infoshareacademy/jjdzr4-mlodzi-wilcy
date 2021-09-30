package com.infoshare;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("myFit app :)");

        DummyUser dummyUser = new DummyUser();
        Gson gson = new Gson();

        gson.toJson(dummyUser, new FileWriter("src/main/resources/dummy.json"));
        gson.toJson(123.45, new FileWriter("src/main/resources/123.json"));
    }
}
