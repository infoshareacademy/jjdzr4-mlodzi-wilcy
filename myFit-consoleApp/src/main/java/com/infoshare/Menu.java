package com.infoshare;

import com.infoshare.Utils.FileUtils;
import com.infoshare.Utils.FoodDataBase;

import java.io.File;
import java.util.Scanner;

public class Menu {


    public static final String RESOURCES_USER_DATA = "src/main/resources/userData/";
    public static final String RESOURCES_PRODUCT_DATA_BASE = "src/main/resources/foodData";

    public void defaultInterface() {
        int numberOfChoices = 6;
        int newChoice;
        ProductsDataBase productsDataBase = new ProductsDataBase();
        UserLoginData userLoginData = new UserLoginData();
        UserData userData = new UserData();

        do {
            System.out.println("--------------------");
            System.out.println("Pick a number to navigate.");
            System.out.println("(1) - Login as a user");
            System.out.println("(2) - Make new user");
            System.out.println("(3) - Check available products");
            System.out.println("(4) - Add new product");
            System.out.println("(5) - Edit a product");
            System.out.println("(6) - Exit");
            System.out.println("--------------------");
            System.out.println("Enter a number:");

            newChoice = choiceChecker(numberOfChoices);

            switch (newChoice) {
                case 1: //Login
                    userLoginData.userLogin();
                    if (userLoginData.checkFileExist()) {
                        FileUtils.readObjectFromJsonFile(RESOURCES_USER_DATA + userLoginData.getName(), UserData.class);
                        userLoggedInterface();
                    } else {
                        userData.fillUserData();
                        FileUtils.writeJsonToFile(RESOURCES_USER_DATA + userLoginData.getName(), userData);
                    }
                    break;
                case 2: //New User
                    userLoginData.createAccount();
                    userData.fillUserData();
                    FileUtils.writeJsonToFile(RESOURCES_USER_DATA + userLoginData.getName(), userData);
                    userLoggedInterface();
                    break;
                case 3: //Check products
                    productsDataBase.readProducts();
                    break;
                case 4: //Add new product
                    productsDataBase.addProduct();
                    break;
                case 5: //Edit product
                    productsDataBase.editProduct();
                    break;
                case 6: //Exit
                    System.out.println("Exiting....");
                    break;
                default:
                    break;
            }
        } while (newChoice != numberOfChoices);
    }


    private void userLoggedInterface() {
        int numberOfChoices = 8;
        int secondChoice;
        ProductsDataBase productsDataBase = new ProductsDataBase();

        System.out.println("--------------------");
        System.out.println("Pick a number to navigate.");
        System.out.println("(1) - Check available products");
        System.out.println("(2) - Add new product");
        System.out.println("(3) - Edit a product");
        System.out.println("(4) - Edit personal info");
        System.out.println("(5) - Add dish");
        System.out.println("(6) - Calculate PPM and CPM");
        System.out.println("(7) - Get diet for whole day");
        System.out.println("(8) - Exit");
        System.out.println("--------------------");
        System.out.println("Enter a number:");


        do {
            secondChoice = choiceChecker(numberOfChoices);
            switch (secondChoice) {
                case 1: //Check products
                    productsDataBase.readProducts();
                    break;
                case 2: //Add product
                    productsDataBase.addProduct();
                    break;
                case 3: //Edit product
                    productsDataBase.editProduct();
                    break;
                case 4: //Edit personal info
                    break;
                case 5: //Add dish
                    break;
                case 6: //Calculate PPM and CPM
                    break;
                case 7: //dieta
                    break;
                case 8: //Exit
                    System.out.println("Exiting to main menu");
                    defaultInterface();
                    break;
                default:
                    break;
            }
        } while (secondChoice != numberOfChoices);
    }


    public static int choiceChecker(int amount) {
        int choice = 0;
        boolean condition = true;

        while (condition) {
            try {
                Scanner scanner = new Scanner(System.in);
                choice = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Give me correct number.");
            }
            if (choice > amount || choice <= 0) {
                System.out.println("Give a number from 1 to " + amount);
            } else {
                condition = false;
            }
        }
        return choice;
    }

}