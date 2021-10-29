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
