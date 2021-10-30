package com.infoshare;

import com.infoshare.Utils.FoodDataBase;

import java.io.File;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.infoshare.Menu.RESOURCES_PRODUCT_DATA_BASE;

public class ProductsDataBase {
    private TypeOfFood typeOfFood;
    private String name;
    private int kcalPer100g;
    private double fatPer100g;
    private double carbohydratesPer100g;
    private double proteinPer100g;

    public ProductsDataBase(TypeOfFood typeOfFood, String name, int kcalPer100g, double fatPer100g, double carbohydratesPer100g, double proteinPer100g) {
        this.typeOfFood = typeOfFood;
        this.name = name;
        this.kcalPer100g = kcalPer100g;
        this.fatPer100g = fatPer100g;
        this.carbohydratesPer100g = carbohydratesPer100g;
        this.proteinPer100g = proteinPer100g;
    }

    public TypeOfFood getTypeOfFood() {
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

    public static void readProducts() {
        System.out.println("All available products:");
        for (ProductsDataBase food : FoodDataBase.foodData) {
            System.out.println(food);
        }
    }


    public void addProduct() {
        System.out.println("What type of this product it is? Write a name:");
        System.out.println();
        System.out.println("(1) - " + TypeOfFood.DRINKS);
        System.out.println("(2) - " + TypeOfFood.FATSANDOILS);
        System.out.println("(3) - " + TypeOfFood.MEAT);
        System.out.println("(4) - " + TypeOfFood.FRUITS);
        System.out.println("(5) - " + TypeOfFood.SEEDSANDNUTS);
        System.out.println("(6) - " + TypeOfFood.CEREALPRODUCTS);
        System.out.println("(7) - " + TypeOfFood.OTHER);
        System.out.println("(8) - " + TypeOfFood.DAIRYANDEGGPRODUCTS);
        System.out.println("(9) - " + TypeOfFood.SPICESANDHERBS);
        System.out.println("(10) - " + TypeOfFood.VEGETABLES);

        chooseType();
        addMethod();
        FoodDataBase.foodData.add(new ProductsDataBase(typeOfFood, name, kcalPer100g, fatPer100g, carbohydratesPer100g, proteinPer100g));
        checkFileExist();
        FoodDataBase.saveToFile();
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
                    if(kcalPer100g < 0) {
                        System.out.println("Enter correct value");
                    } else {
                    break; }

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
                if(fatPer100g < 0) {
                    System.out.println("Enter correct value.");
                }
                else {
                    break;
                }
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
                if(carbohydratesPer100g < 0) {
                    System.out.println("Enter correct value.");
                } else {
                break; }
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
                if(proteinPer100g < 0) {
                    System.out.println("Enter correct value.");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Enter correct value.");
                continue;
            }
        }
        System.out.println(name + " has beed added to librabry.");
        return false;
    }

    public void chooseType() {
        int chooseNumber;
        while (true)
            try {
                Scanner scanner = new Scanner(System.in);
                chooseNumber = scanner.nextInt();
                if (chooseNumber == 1) {
                    typeOfFood = TypeOfFood.DRINKS;
                    break;
                } else if (chooseNumber == 2) {
                    typeOfFood = TypeOfFood.FATSANDOILS;
                    break;
                } else if (chooseNumber == 3) {
                    typeOfFood = TypeOfFood.MEAT;
                    break;
                } else if (chooseNumber == 4) {
                    typeOfFood = TypeOfFood.FRUITS;
                    break;
                } else if (chooseNumber == 5) {
                    typeOfFood = TypeOfFood.SEEDSANDNUTS;
                    break;
                } else if (chooseNumber == 6) {
                    typeOfFood = TypeOfFood.CEREALPRODUCTS;
                    break;
                } else if (chooseNumber == 7) {
                    typeOfFood = TypeOfFood.OTHER;
                    break;
                } else if (chooseNumber == 8) {
                    typeOfFood = TypeOfFood.DAIRYANDEGGPRODUCTS;
                    break;
                } else if (chooseNumber == 9) {
                    typeOfFood = TypeOfFood.SPICESANDHERBS;
                    break;
                } else if (chooseNumber == 10) {
                    typeOfFood = TypeOfFood.VEGETABLES;
                    break;
                } else {
                    System.out.println("You write uncorrectly number");
                    System.out.println("Write number from 1 to 10.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Write number from 1 to 10.");
            }
    }

    public boolean checkFileExist() {
        File file = new File(RESOURCES_PRODUCT_DATA_BASE + name);
        return file.exists();
    }

    @Override
    public String toString() {
        return "Product name: " + name +
                ", type of food: " + typeOfFood +
                ", kcal per 100g: " + kcalPer100g +
                ", fat per 100g: " + fatPer100g +
                ", carbohydrates per 100g: " + carbohydratesPer100g +
                ", protein per 100g: " + proteinPer100g;
    }
}