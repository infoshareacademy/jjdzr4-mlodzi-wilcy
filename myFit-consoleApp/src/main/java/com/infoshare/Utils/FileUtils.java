package com.infoshare.Utils;

import com.google.gson.Gson;
import com.infoshare.DummyUser;

import java.io.*;

public class FileUtils {

    public static void writeJsonToFile(Object object, String path) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(path)) {
            gson.toJson(object, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Object readObjectFromJsonFile(String path) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(path)) {
            Object object = gson.fromJson(reader, DummyUser.class);
            return object;
        } catch (IOException e) {
            System.out.println("Exception during reading json file: " + e.getMessage());
        }
        return null;
    }
}
