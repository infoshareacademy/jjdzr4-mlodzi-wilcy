package com.infoshare;

import com.infoshare.Utils.DishUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Diet {
    private int CPM;
    private double weightGoal;
    private double weight;
    public List<DishDataBase> dietDishes = new ArrayList<>();
    private int actualKcal;

    Diet(int CPM, double weightGoal, double weight) {
        this.CPM = CPM;
        this.weightGoal = weightGoal;
        this.weight = weight;
    }


    public void getDiet() {
        if (dietDishes.isEmpty()) {
            addDietDishes(getMaxKcal());
            fillDiet();
        } else {
            System.out.println(dietDishes);
            System.out.println("This is your actual diet kcal: " + actualKcal);
        }
    }

    private int getMaxKcal() {
        int maxKcal;
        if (weightGoal < weight) {
            maxKcal = CPM + 250;
        } else {
            maxKcal = CPM - 250;
        }
        return maxKcal;
    }

    public void addDietDishes(int maxKcal) {
        String dishName;
        boolean shouldDietHaveNextDish = false;
        System.out.println(DishUtils.dishDataBaseArrayList);
        System.out.println("Write the name of dish you would like to add:");
        do {
            Scanner scanner = new Scanner(System.in);
            dishName = scanner.nextLine();
            while (!DishUtils.dishDataBaseArrayList.contains(new DishDataBase(dishName))) {
                System.out.println("There is no such dish, type again");
                break;
            }
            for (int i = 0; i < DishUtils.dishDataBaseArrayList.size(); i++) {
                if (DishUtils.dishDataBaseArrayList.get(i).equals(new DishDataBase(dishName))) {
                    DishDataBase dishData = DishUtils.dishDataBaseArrayList.get(i);
                    actualKcal += dishData.getSumOfKcalPer100g();
                    dietDishes.add(dishData);
                    break;
                }
            }
            System.out.println("Do You want to add another dish to the diet? Type anything to confirm or just press Enter to finish adding the dish.");
            String nextDishAnswer = scanner.nextLine();

            if (nextDishAnswer.isEmpty()) {
                shouldDietHaveNextDish = false;
            } else {
                shouldDietHaveNextDish = true;
            }
        } while (shouldDietHaveNextDish || actualKcal > maxKcal);
        if (actualKcal > maxKcal) {
            System.out.println("You can't add more dishes");
        }
    }

    private void fillDiet() {
        for (int i = 0; i < dietDishes.size(); i++) {
            DishDataBase newDish = dietDishes.get(i);
            dietDishes.add(newDish);
            actualKcal += newDish.getSumOfKcalPer100g();
            if (actualKcal > getMaxKcal()) {
                dietDishes.remove(i);
                break;
            }
        }
    }

}
