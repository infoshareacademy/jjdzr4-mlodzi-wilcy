package com.infoshare;

import com.infoshare.Utils.UserDataBase;

public class App {
    public static void main(String[] args) {
        UserDataBase.loadFromFile(); //uploadowanie pliku z danymi logowania
        Interface anInterface = new Interface();
        anInterface.defaultInterface();
    }
}
