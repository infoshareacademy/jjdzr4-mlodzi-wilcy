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
    private double PPM;
    private double CPM;

    public void fillUserData() {
        System.out.println("Before enter fill your personal information");
        setName();
        setGender();
        setAge();
        setHeight();
        setWeight();
        setLevelOfJobActivity();
        setLevelOfPrivateActivity();
        calculatePPM();
        calculateCPM();
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

    public double calculatePPM (){
        if (gender.equals("male")){
            PPM = (double) (10 * weight) + (6.25 * height) - (5 * age) + 5;
        } else {
            PPM = (double) (10 * weight) + (6.25 * height) - (5 * age) - 161;
        }
        return PPM;
    }

    public double calculateCPM (){
        if (levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("low")){
            CPM = PPM * 1.5;
        } else if ((levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("medium")) ||
                (levelOfPrivateActivity.equals("medium") && levelOfJobActivity.equals("low")) ){
            CPM = PPM * 1.7;
        } else if ((levelOfPrivateActivity.equals("low") && levelOfJobActivity.equals("high")) ||
                (levelOfPrivateActivity.equals("high") && levelOfJobActivity.equals("low"))){
            CPM = PPM * 1.9;
        } else if (levelOfPrivateActivity.equals("medium") && levelOfJobActivity.equals("medium")){
            CPM = PPM * 2;
        } else if (levelOfPrivateActivity.equals("high") && levelOfJobActivity.equals("high")){
            CPM = PPM * 2.2;
        }
        return CPM;
    }

    public double getPPM() {

        System.out.println("Your basic metabolism is: " + CPM + " kcal.");
        return PPM;
    }

    public double getCPM() {
        System.out.println("Your Total Caloric Demand is: " + CPM + " kcal.");
        return CPM;
    }
}
