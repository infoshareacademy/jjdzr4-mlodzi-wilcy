package com.infoshare.myfitwebapp.model;

public class UserData {
    private String name;
    private String gender;
    private int age;
    private int height;
    private double weight;
    private String levelOfJobActivity;
    private String levelOfPrivateActivity;
    private double weightGoal;
    private double PPM;
    private double CPM;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLevelOfJobActivity() {
        return levelOfJobActivity;
    }

    public void setLevelOfJobActivity(String levelOfJobActivity) {
        this.levelOfJobActivity = levelOfJobActivity;
    }

    public String getLevelOfPrivateActivity() {
        return levelOfPrivateActivity;
    }

    public void setLevelOfPrivateActivity(String levelOfPrivateActivity) {
        this.levelOfPrivateActivity = levelOfPrivateActivity;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public double getPPM() {
        return PPM;
    }

    public void setPPM(double PPM) {
        this.PPM = PPM;
    }

    public double getCPM() {
        return CPM;
    }

    public void setCPM(double CPM) {
        this.CPM = CPM;
    }
}