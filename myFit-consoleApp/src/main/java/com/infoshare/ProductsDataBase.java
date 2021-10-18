package com.infoshare;


import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshare.Menu.choiceChecker;

public class ProductsDataBase {
    ProductInfo productInfo = new ProductInfo();

    public void readProducts() {
        System.out.println("All available products:");
    }

    public void addProduct() {
        int numberOfChoices = 6;
        int newChoice;

        System.out.println("What type of this product it is?");
        System.out.println("Write number:");

        do {
            System.out.println("(1) - Napoje");
            System.out.println("(2) - tłuszcze i oleje");
            System.out.println("(3) - Mięso");
            System.out.println("(4) - Owoce");
            System.out.println("(5) - Nasiona i orzechy");
            System.out.println("(6) - produkty zbozowe");
            System.out.println("(7) - Inne");
            System.out.println("(8) - Nabiał i produkty jajeczne");
            System.out.println("(9) - Przyprawy i zioła");
            System.out.println("(10) - Warzywa");

            newChoice = choiceChecker(numberOfChoices);

            switch (newChoice) {
                case 1: //Napoje
                case 2: //Tłuszcze i oleje
                case 3: //Mięso
                case 4: //Owoce
                case 5: //Nasiona i orzechy
                case 6: //Produkty zbozowe
                case 7: //Inne
                case 8: //Nabiał i produkty jajeczne
                case 9: //Przyprawy i zioła
                case 10: //Warzywa

            }
//
//
//
//        Scanner scanner = new Scanner(System.in);
//        name = scanner.nextLine();
//
//        System.out.println("Write how many calories does this product have:");
//        scanner = new Scanner(System.in);
//        try {
//            calories = scanner.nextInt();
//        } catch (InputMismatchException e){
//            e.printStackTrace();
//        }
//        System.out.println("New product " + name + " with " + calories + "calories added.");
//    }
        } while (newChoice != numberOfChoices);
    }



    public void editProduct() {
        String name;

        System.out.println("What product would you like to modify? Write a name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Product " + name + " was modified.");
    }
}
