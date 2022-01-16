package com.infoshare;

import java.util.Objects;

public class ProductInfo {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInfo that = (ProductInfo) o;
        return kcalPer100g == that.kcalPer100g && Double.compare(that.fatPer100g, fatPer100g) == 0 && Double.compare(that.carbohydratesPer100g, carbohydratesPer100g) == 0 && Double.compare(that.proteinPer100g, proteinPer100g) == 0 && name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, kcalPer100g, fatPer100g, carbohydratesPer100g, proteinPer100g);
    }

    @Override
    public String toString() {
        return "InfoProduct{" +
                "name='" + name + '\'' +
                ", kcalPer100g=" + kcalPer100g +
                ", fatPer100g=" + fatPer100g +
                ", carbohydratesPer100g=" + carbohydratesPer100g +
                ", proteinPer100g=" + proteinPer100g +
                '}';
    }
}