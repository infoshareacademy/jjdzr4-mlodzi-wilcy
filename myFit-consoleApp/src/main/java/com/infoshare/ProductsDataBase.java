package com.infoshare;

import com.infoshare.Utils.FileUtils;
import com.infoshare.Utils.FoodDataBase;
import com.infoshare.Utils.UserDataBase;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshare.Menu.RESOURCES_PRODUCT_DATA_BASE;
import static com.infoshare.Menu.choiceChecker;

public class ProductsDataBase {
    private String typeOfFood;
    private String name;
    private int kcalPer100g;
    private double fatPer100g;
    private double carbohydratesPer100g;
    private double proteinPer100g;

    public ProductsDataBase(String typeOfFood, String name, int kcalPer100g, double fatPer100g, double carbohydratesPer100g, double proteinPer100g) {
        this.typeOfFood = typeOfFood;
        this.name = name;
        this.kcalPer100g = kcalPer100g;
        this.fatPer100g = fatPer100g;
        this.carbohydratesPer100g = carbohydratesPer100g;
        this.proteinPer100g = proteinPer100g;
    }

    public String getTypeOfFood() {
        return typeOfFood;
    }

    public String getName() {
        return name;
    }

    public int getKcalPer100g() {
        return kcalPer100g;
    }

    public double getFatPer100g() {
        return fatPer100g;
    }

    public double getCarbohydratesPer100g() {
        return carbohydratesPer100g;
    }

    public double getProteinPer100g() {
        return proteinPer100g;
    }

    public ProductsDataBase() {
    }

    public void readProducts() {
        System.out.println("All available products:");
    }


    public void addProduct() {
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

        chooseType();
        addMethod();
        FoodDataBase.foodData.add(new ProductsDataBase(typeOfFood, name, kcalPer100g, fatPer100g, carbohydratesPer100g, proteinPer100g));
        checkFileExist();
        FoodDataBase.saveToFile2();


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
                System.out.println("Write name of the product:");
                Scanner scanner = new Scanner(System.in);
                name = scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Enter the correct value.");
            }

            while (true) {
                try {
                    System.out.println("Write how many calories per 100 grams this product has:");
                    Scanner scanner = new Scanner(System.in);
                    kcalPer100g = scanner.nextInt();
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
                fatPer100g = scanner.nextDouble();
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
                carbohydratesPer100g = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;
            }
        }
        while (true) {
            try {
                System.out.println("Write how many proteins per 100 grams this product has:");
                Scanner scanner = new Scanner(System.in);
                proteinPer100g = scanner.nextDouble();
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;

            }
        }
        System.out.println(name + " has beed added to librabry.");
        return false;
    }

    public void chooseType() {
        while (true)
            try {
                Scanner scanner = new Scanner(System.in);
                typeOfFood = scanner.nextLine();
                if (typeOfFood.equals("1")) {
                    typeOfFood = "Napoje";
                    break;
                } else if (typeOfFood.equals("2")) {
                    typeOfFood = "Tłuszcze i oleje";
                    break;
                } else if (typeOfFood.equals("3")) {
                    typeOfFood = "Mięso";
                    break;
                } else if (typeOfFood.equals("4")) {
                    typeOfFood = "Owoce";
                    break;
                } else if (typeOfFood.equals("5")) {
                    typeOfFood = "Nasiona i orzechy";
                    break;
                } else if (typeOfFood.equals("6")) {
                    typeOfFood = "Produkty zbozowe";
                    break;
                } else if (typeOfFood.equals("7")) {
                    typeOfFood = "Inne";
                    break;
                } else if (typeOfFood.equals("8")) {
                    typeOfFood = "Nabiał i produkty jajeczne";
                    break;
                } else if (typeOfFood.equals("9")) {
                    typeOfFood = "Przyprawy i zioła";
                    break;
                } else if (typeOfFood.equals("10")) {
                    typeOfFood = "Warzywa";
                    break;
                } else {
                    System.out.println("Podałeś niewłaściwy numer.");
                    System.out.println("Podaj numer od 1 do 10.");
                }
            } catch (InputMismatchException e) {
                e.printStackTrace();
            }
    }
    public boolean checkFileExist() {
        File file = new File(RESOURCES_PRODUCT_DATA_BASE + name);
        return file.exists();
    }
}
