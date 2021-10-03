package com.infoshare;

import java.util.Scanner;

public class Interface {

    public void defaultInterface() {
        int numberOfChoices = 6;
        int newChoice;
        UsersDataBase userDataBase = new UsersDataBase();
        ProductsDataBase productsDataBase = new ProductsDataBase();

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
                    userDataBase.logInUser();
                    userLoggedInterface();
                    break;
                case 2: //New User
                    userDataBase.addUser();
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
        int numberOfChoices = 4;
        int secondChoice;
        UsersDataBase userDataBase = new UsersDataBase();
        ProductsDataBase productsDataBase = new ProductsDataBase();

// Tutaj jest problem. Jak wejdzie się w jakąś opcję, to ona się zapętla

        System.out.println("--------------------");
        System.out.println("Pick a number to navigate.");
        System.out.println("(1) - Check available products");
        System.out.println("(2) - Add new product");
        System.out.println("(3) - Edit a product");
        System.out.println("(4) - Exit");
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
                case 4: //Exit
                    System.out.println("Exiting to main menu");
                    defaultInterface();
                    break;
                default:
                    break;
            }
        } while (secondChoice != numberOfChoices);
    }


    private int choiceChecker(int amount) {
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