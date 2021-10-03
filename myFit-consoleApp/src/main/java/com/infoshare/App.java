package com.infoshare;

import static com.infoshare.Utils.FileUtils.writeJsonToFile;

public class App {
    public static void main(String[] args) {
        System.out.println("myFit app :)");

        DummyUser dummyUser = new DummyUser();

        String pathToSave = "src/main/resources/dummy.json";
        writeJsonToFile(dummyUser, pathToSave);

//        Interface anInterface = new Interface();
//        anInterface.defaultInterface();
    }
}
