package com.infoshare.Utils;

import com.google.gson.Gson;
import com.infoshare.DummyUser;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileUtils {

    public static void writeJsonToFile(DummyUser dummyUser, String path) {
        Gson gson = new Gson();
        try (Writer writer = new FileWriter(path)) {
            gson.toJson(dummyUser, writer);
        } catch (IOException e) {
            System.out.println("Exception during saving json file: " + e.getMessage());
        }
    }
}
