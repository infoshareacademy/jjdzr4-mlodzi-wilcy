package com.infoshare.Utils;

import com.google.gson.Gson;

import java.io.*;

public class FileUtils {

    public static void writeJsonToFile(String path, Object object) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(path)) {
            gson.toJson(object, writer);
            writer.flush();
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Object readObjectFromJsonFile(String path, Class className) {
        Gson gson = new Gson();
        try (Reader reader = new FileReader(path)) {
            Object object = gson.fromJson(reader, className);
            return object;
        } catch (IOException e) {
            System.out.println("Exception during reading json file: " + e.getMessage());
        }
        return null;
    }
}
