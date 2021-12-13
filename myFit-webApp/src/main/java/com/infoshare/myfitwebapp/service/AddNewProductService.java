package com.infoshare.myfitwebapp.service;

import com.infoshare.TypeOfFood;
import org.springframework.stereotype.Service;

import java.util.InputMismatchException;
import java.util.Scanner;

@Service
public class AddNewProductService {
    private TypeOfFood typeOfFood;
    private String name;
    private int kcalPer100g;
    private double fatPer100g;
    private double carbohydratesPer100g;
    private double proteinPer100g;

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
                    if (kcalPer100g < 0) {
                        System.out.println("Enter correct value");
                    } else {
                        break;
                    }

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
                if (fatPer100g < 0) {
                    System.out.println("Enter correct value.");
                } else {
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
                if (carbohydratesPer100g < 0) {
                    System.out.println("Enter correct value.");
                } else {
                    break;
                }
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
                if (proteinPer100g < 0) {
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
}
