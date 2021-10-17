package com.infoshare;

import com.infoshare.Utils.UserDataBase;

public class App {
    public static void main(String[] args) {
        UserDataBase.loadFromFile();
        Interface anInterface = new Interface();
        anInterface.defaultInterface();
    }
}
