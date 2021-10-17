package com.infoshare;

import java.util.Scanner;

public class UserData {
    private String name;
    private String gender;
    private int age;
    private int height;
    private int weight;
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
        System.out.println("Insert your name:");
        this.name = scanner.nextLine();
    }

    public void setGender() {
        System.out.println("Your gender:");
        System.out.println("1. male");
        System.out.println("2. female");
        int choice = Interface.choiceChecker(2);
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
        System.out.println("Your age:");
        Scanner scanner = new Scanner(System.in);
        this.age = scanner.nextInt();
    }

    public void setHeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your height");
        this.height = scanner.nextInt();
    }

    public void setWeight() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your weight");
        this.weight = scanner.nextInt();
    }

    public void setLevelOfJobActivity() {
        System.out.println("Your level of job activity");
        System.out.println("1. low");
        System.out.println("2. medium");
        System.out.println("3. High");
        int choice = Interface.choiceChecker(3);
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
        System.out.println("3. High");
        int choice = Interface.choiceChecker(3);
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
