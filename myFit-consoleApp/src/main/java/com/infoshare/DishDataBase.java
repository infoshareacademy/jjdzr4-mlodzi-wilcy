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
    private List<String> productsNameList = new ArrayList<>();

    public DishDataBase() {
    }

    public DishDataBase(String dishName) {
        this.dishName = dishName;
    }

    public DishDataBase(String dishName, int sumOfKcalPer100g, double sumOfFatPer100g, double sumOfCarbohydratesPer100g, double sumOfProteinPer100g, List<String> productsNameList) {
        this.dishName = dishName;
        this.sumOfKcalPer100g = sumOfKcalPer100g;
        this.sumOfFatPer100g = sumOfFatPer100g;
        this.sumOfCarbohydratesPer100g = sumOfCarbohydratesPer100g;
        this.sumOfProteinPer100g = sumOfProteinPer100g;
        this.productsNameList = productsNameList;
    }

    public void addDish() {
        List<ProductsDataBase> temporaryProductsDataBaseList = new ArrayList<>();
        String temporaryDishName;
        int temporarySumOfKcalPer100g = 0;
        double temporarySumOfFatPer100g = 0.0;
        double temporarySumOfCarbohydratesPer100g = 0.0;
        double temporarySumOfProteinPer100g = 0.0;
        while (true) {
            try {
                System.out.println("Available products:");
                ProductsDataBase.readProducts();

                System.out.println("\nWrite the name of your new dish:");
                Scanner scanner = new Scanner(System.in);
                temporaryDishName = scanner.nextLine();
                boolean shouldDishHaveNextProduct = false;

                try {
                    do {
                        temporaryProductsDataBaseList.add(getNextProductName(scanner));
                        System.out.println("Do You want to add another product to the dish? Type anything to confirm or just press Enter to finish adding the dish.");
                        String nextProductAnswer = scanner.nextLine();

                        if (nextProductAnswer.isEmpty()) {
                            shouldDishHaveNextProduct = false;
                        } else {
                            shouldDishHaveNextProduct = true;
                        }
                    }
                    while (shouldDishHaveNextProduct);

                    temporarySumOfKcalPer100g = calculateSumOfKcalPer100g(temporaryProductsDataBaseList);
                    temporarySumOfFatPer100g = calculateSumOfFatPer100g(temporaryProductsDataBaseList);
                    temporarySumOfCarbohydratesPer100g = calculateSumOfCarbohydratesPer100g(temporaryProductsDataBaseList);
                    temporarySumOfProteinPer100g = calculateSumOfProteinPer100g(temporaryProductsDataBaseList);
                } catch (NoSuchElementException e) {
                    System.out.println("Product doesn't exist.");
                }
                break;
            } catch (InputMismatchException e) {
                System.out.println("Enter the correct value.");
            }
        }

        DishUtils.dishDataBaseArrayList.add(new DishDataBase(temporaryDishName, temporarySumOfKcalPer100g, temporarySumOfFatPer100g, temporarySumOfCarbohydratesPer100g, temporarySumOfProteinPer100g, getProductNames(temporaryProductsDataBaseList)));
        DishUtils.saveToFile();
    }

    private ProductsDataBase getNextProductName(Scanner scanner) {
        System.out.println("Type the product name");
        String productName1 = scanner.nextLine();

        ProductsDataBase productsDataBase1 = FoodDataBase.foodData.stream().filter(
                f -> f.getName().equals(productName1)).findFirst().get();
        return productsDataBase1;
    }

    private int calculateSumOfKcalPer100g(List<ProductsDataBase> productsDataBaseList) {
        int temporarySumOfKcalPer100g = 0;
        for (ProductsDataBase p : productsDataBaseList) {
            temporarySumOfKcalPer100g += p.getKcalPer100g();
        }
        return temporarySumOfKcalPer100g;
    }

    private double calculateSumOfFatPer100g(List<ProductsDataBase> productsDataBaseList) {
        double temporarySumOfFatPer100g = 0.0;
        for (ProductsDataBase p : productsDataBaseList) {
            temporarySumOfFatPer100g += p.getFatPer100g();
        }
        return temporarySumOfFatPer100g;
    }

    private double calculateSumOfCarbohydratesPer100g(List<ProductsDataBase> productsDataBaseList) {
        double temporarySumOfCarbohydratesPer100g = 0.0;
        for (ProductsDataBase p : productsDataBaseList) {
            temporarySumOfCarbohydratesPer100g += p.getCarbohydratesPer100g();
        }
        return temporarySumOfCarbohydratesPer100g;
    }

    private double calculateSumOfProteinPer100g(List<ProductsDataBase> productsDataBaseList) {
        double temporarySumOfProteinPer100g = 0.0;
        for (ProductsDataBase p : productsDataBaseList) {
            temporarySumOfProteinPer100g += p.getProteinPer100g();
        }
        return temporarySumOfProteinPer100g;
    }

    private List<String> getProductNames(List<ProductsDataBase> productsDataBaseList) {
        List<String> listOfDishNames = new ArrayList<>();
        for (ProductsDataBase product : productsDataBaseList) {
            listOfDishNames.add(product.getName());
        }
        return listOfDishNames;
    }

    public int getSumOfKcalPer100g() {
        return sumOfKcalPer100g;
    }

    public String getDishName() {
        return dishName;
    }

    @Override
    public String toString() {
        return "\ndish name: " + dishName + " sumOfKcalPer100g: " + sumOfKcalPer100g;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishDataBase that = (DishDataBase) o;
        return Objects.equals(dishName, that.dishName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dishName);
    }
}