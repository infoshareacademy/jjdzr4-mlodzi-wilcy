package com.infoshare;


import java.util.Scanner;

public class ProductsDataBase {
    public void readProducts() {
        System.out.println("All available products:");
    }

    public void addProduct() {
        String name;
        int calories;
        System.out.println("What product would you like to add? Write a name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Write how many calories does this product have:");
        scanner = new Scanner(System.in);
        calories = scanner.nextInt();

        System.out.println("New product " + name + " with " + calories + "calories added.");
    }

    public void editProduct() {
        String name;

        System.out.println("What product would you like to modify? Write a name:");
        Scanner scanner = new Scanner(System.in);
        name = scanner.nextLine();
        System.out.println("Product " + name + " was modified.");
    }
}
