package com.infoshare;

import java.util.Scanner;

public class UserData {
    private String name;
    private String gender;
    private int age;
    private int height;
    private double weight;
    private String levelOfJobActivity;
    private String levelOfPrivateActivity;

    public void fillUserData() {
        System.out.println("Before enter fill your personal information");
        setName();
        setGender();
        setAge();
        setHeight();
        setWeight();
        setLevelOfJobActivity();
        setLevelOfPrivateActivity();
    }


    public void setName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Type your name:");
        this.name = scanner.nextLine();
    }

    public void setGender() {
        System.out.println("Your gender:");
        System.out.println("1. male");
        System.out.println("2. female");
        int choice = Menu.choiceChecker(2);
        switch (choice) {
            case 1:
                gender = "male";
                break;
            case 2:
                gender = "female";
                break;
        }
    }

    public void setAge() {
        while (true) {
            try {
                System.out.println("Your age:");
                Scanner scanner = new Scanner(System.in);
                this.age = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Write your age correctly.");
            }
        }
    }

    public void setHeight() {
        while (true) {
            try {
                System.out.println("Your height");
                Scanner scanner = new Scanner(System.in);
                this.height = scanner.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Write your hight in centimeters.");
            }
        }
    }

    public void setWeight() {
        while (true) {
            try {
                Scanner scanner = new Scanner(System.in);
                System.out.println("Your weight");
                this.weight = scanner.nextDouble();
                break;
            } catch (Exception e) {
                System.out.println("Write your weight correctly");
            }

        }
    }

    public void setLevelOfJobActivity() {
        System.out.println("Your level of job activity");
        System.out.println("1. low");
        System.out.println("2. medium");
        System.out.println("3. high");
        int choice = Menu.choiceChecker(3);
        switch (choice) {
            case 1:
                levelOfJobActivity = "low";
                break;
            case 2:
                levelOfJobActivity = "medium";
                break;
            case 3:
                levelOfJobActivity = "high";
                break;
        }
    }

    public void setLevelOfPrivateActivity() {
        System.out.println("Your level of your private activity");
        System.out.println("1. low");
        System.out.println("2. medium");
        System.out.println("3. high");
        int choice = Menu.choiceChecker(3);
        switch (choice) {
            case 1:
                levelOfPrivateActivity = "low";
                break;
            case 2:
                levelOfPrivateActivity = "medium";
                break;
            case 3:
                levelOfPrivateActivity = "high";
                break;
        }
    }
}
