package com.infoshare.myfitwebapp.model;

public class ProductData {
    private String name;
    private int kcalPer100g;
    private double fatPer100g;
    private double carbohydratesPer100g;
    private double proteinPer100g;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getKcalPer100g() {
        return kcalPer100g;
    }

    public void setKcalPer100g(int kcalPer100g) {
        this.kcalPer100g = kcalPer100g;
    }

    public double getFatPer100g() {
        return fatPer100g;
    }

    public void setFatPer100g(double fatPer100g) {
        this.fatPer100g = fatPer100g;
    }

    public double getCarbohydratesPer100g() {
        return carbohydratesPer100g;
    }

    public void setCarbohydratesPer100g(double carbohydratesPer100g) {
        this.carbohydratesPer100g = carbohydratesPer100g;
    }

    public double getProteinPer100g() {
        return proteinPer100g;
    }

    public void setProteinPer100g(double proteinPer100g) {
        this.proteinPer100g = proteinPer100g;
    }
}
