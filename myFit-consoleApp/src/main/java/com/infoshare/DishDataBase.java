package com.infoshare;

import com.infoshare.Utils.DishUtils;
import com.infoshare.Utils.FoodDataBase;

import java.util.*;

public class DishDataBase {
    private String dishName;
    private int sumOfKcalPer100g;
    private double sumOfFatPer100g;
    private double sumOfCarbohydratesPer100g;
    private double sumOfProteinPer100g;
    private List<ProductsDataBase> productsDataBaseList = new ArrayList<>();

    public DishDataBase() {
    }

    public DishDataBase(String dishName, int sumOfKcalPer100g, double sumOfFatPer100g, double sumOfCarbohydratesPer100g, double sumOfProteinPer100g, List<ProductsDataBase> productsDataBaseList) {
        this.dishName = dishName;
        this.sumOfKcalPer100g = sumOfKcalPer100g;
        this.sumOfFatPer100g = sumOfFatPer100g;
        this.sumOfCarbohydratesPer100g = sumOfCarbohydratesPer100g;
        this.sumOfProteinPer100g = sumOfProteinPer100g;
        this.productsDataBaseList = productsDataBaseList;
    }

    public void addDish() {

        while (true) {
            try {
                System.out.println("Available products:");
                ProductsDataBase.readProducts();

                System.out.println("Write the name of your new dish:");
                Scanner scanner = new Scanner(System.in);
                dishName = scanner.nextLine();

                System.out.println("Type the first product name");
                String productName1 = scanner.nextLine();

                System.out.println("Type the second product name");
                String productName2 = scanner.nextLine();

                ProductsDataBase productsDataBase1 = FoodDataBase.foodData.stream().filter(
                        f -> f.getName().equals(productName1)).findFirst().get();
                ProductsDataBase productsDataBase2 = FoodDataBase.foodData.stream().filter(
                        f -> f.getName().equals(productName2)).findFirst().get();

                try {
                    productsDataBaseList = Arrays.asList(productsDataBase1, productsDataBase2);
                    sumOfKcalPer100g = productsDataBase1.getKcalPer100g() + productsDataBase2.getKcalPer100g();
                    sumOfFatPer100g = productsDataBase1.getFatPer100g() + productsDataBase2.getFatPer100g();
                    sumOfCarbohydratesPer100g = productsDataBase1.getCarbohydratesPer100g() + productsDataBase2.getCarbohydratesPer100g();
                    sumOfProteinPer100g = productsDataBase1.getProteinPer100g() + productsDataBase2.getProteinPer100g();
                } catch (NoSuchElementException e) {
                    System.out.println("Product doesn't exist.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter the correct value.");
            }
        }

        DishUtils.dishDataBaseArrayList.add(new DishDataBase(dishName, sumOfKcalPer100g, sumOfFatPer100g, sumOfCarbohydratesPer100g, sumOfProteinPer100g, productsDataBaseList));
        DishUtils.saveToFile();
    }
}