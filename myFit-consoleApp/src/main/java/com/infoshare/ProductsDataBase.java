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
        int numberOfChoices = 10;
        int newChoice;

        System.out.println("What type of this product it is?");
        System.out.println("Write number:");
        System.out.println();

        System.out.println("(1) - Napoje");
        System.out.println("(2) - Tłuszcze i oleje");
        System.out.println("(3) - Mięso");
        System.out.println("(4) - Owoce");
        System.out.println("(5) - Nasiona i orzechy");
        System.out.println("(6) - Produkty zbozowe");
        System.out.println("(7) - Inne");
        System.out.println("(8) - Nabiał i produkty jajeczne");
        System.out.println("(9) - Przyprawy i zioła");
        System.out.println("(10) - Warzywa");

        newChoice = choiceChecker(numberOfChoices);

        switch (newChoice) {
            case 1: //Napoje
                addMethod();
                break;
            case 2: //Tłuszcze i oleje
                addMethod();
                break;
            case 3: //Mięso
                addMethod();
                break;
            case 4: //Owoce
                addMethod();
                break;
            case 5: //Nasiona i orzechy
                addMethod();
                break;
            case 6: //Produkty zbozowe
                addMethod();
                break;
            case 7: //Inne
                addMethod();
                break;
            case 8: //Nabiał i produkty jajeczne
                addMethod();
                break;
            case 9: //Przyprawy i zioła
                addMethod();
                break;
            case 10: //Warzywa
                addMethod();
                break;
            default:
                break;
        }
    }

    public void editProduct() {
        String name;

        System.out.println("What product would you like to modify? Write a name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Product " + name + " was modified.");
    }

    public boolean addMethod() {
        while (true) {
            try {
                System.out.println("Write name of this product:");
                Scanner scanner = new Scanner(System.in);
                productInfo.setName(scanner.nextLine());
            } catch (InputMismatchException e) {
                System.out.println("Enter the correct value.");
            }

            while (true) {
                try {
                    System.out.println("Write how many calories per 100 grams this product has:");
                    Scanner scanner = new Scanner(System.in);
                    productInfo.setKcalPer100g(scanner.nextInt());
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Enter correct value.");
                    continue;
                }
            }
            break;
        }
        while (true) {
            try {
                System.out.println("Write how many fats per 100 grams this product has:");
                Scanner scanner = new Scanner(System.in);
                productInfo.setFatPer100g(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;
            }
        }
        while (true) {
            try {
                System.out.println("Write how many carbohydrates per 100 grams this product has:");
                Scanner scanner = new Scanner(System.in);
                productInfo.setCarbohydratesPer100g(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;
                }
            }
        while(true) {
            try {
                System.out.println("Write how many proteins per 100 grams this product has:");
                Scanner scanner = new Scanner(System.in);
                productInfo.setProteinPer100g(scanner.nextInt());
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;

            }
        }
        System.out.println(productInfo.getName() + " has beedn added to librabry.");
            return true;
        }
    }

