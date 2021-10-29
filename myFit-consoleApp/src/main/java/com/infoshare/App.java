package com.infoshare;
import com.infoshare.Utils.DishUtils;
import com.infoshare.Utils.FoodDataBase;
import com.infoshare.Utils.UserDataBase;

public class App {
    public static void main(String[] args) {
        UserDataBase.loadFromFile(); //uploadowanie pliku z danymi logowania;
        DishUtils.loadFromFile();
        FoodDataBase.loadFromFile();
        Menu anMenu = new Menu();
        anMenu.defaultInterface();
    }
}
