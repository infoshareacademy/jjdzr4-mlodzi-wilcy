package com.infoshare.Utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.List;

public class FileUtils {

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void writeListToJsonFile(String path, List<T> list) {
        try (Writer writer = new FileWriter(path)) {
            GSON.toJson(list, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static <T> List<T> readListFromJsonFile(String path) {
        try (Reader reader = new FileReader(path)) {
            System.out.println("Reading from json file: " + path);
            Type collectionType = new TypeToken<List<T>>() {
            }.getType();
            List<T> collection = GSON.fromJson(reader, collectionType);
            System.out.println("List successfully uploaded. Number of elements: " + collection.size());
            return collection;
        } catch (IOException e) {
            System.out.println("File not found or broken: " + e.getMessage());
            return Collections.emptyList();
        }
    }

    public static void checkFileExists(String file) {
        if (Files.notExists(Path.of(file))) {
            try {
                Files.createFile(Path.of(file));
            } catch (IOException e) {
                System.out.println("Failed to create a file: " + file);
            }
        }
    }


    public static void writeJsonToFile(String path, Object object) {
        Gson gson = new Gson();
        try {
            Writer writer = new BufferedWriter(new FileWriter(path));
            gson.toJson(object, writer);
            writer.close();
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }

    public static Object readObjectFromJsonFile(String path, Class className) {
        Gson gson = new Gson();
        try {
            Reader reader = new FileReader(path);
            Object object = gson.fromJson(reader, className);
            reader.close();
            return object;
        } catch (IOException e) {
            System.out.println("Exception during reading json file: " + e.getMessage());
        }
        return null;
    }
}
