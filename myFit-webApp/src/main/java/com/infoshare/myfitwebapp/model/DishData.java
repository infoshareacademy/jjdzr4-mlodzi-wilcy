package com.infoshare.myfitwebapp.model;

import javax.validation.constraints.NotEmpty;
import java.util.List;

public class DishData {
    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    private long id;
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private String dishName;
    private int sumOfKcalPer100g;
    private double sumOfFatPer100g;
    private double sumOfCarbohydratesPer100g;
    private double sumOfProteinPer100g;
    private List<ProductData> productsDataList;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public int getSumOfKcalPer100g() {
        return sumOfKcalPer100g;
    }

    public void setSumOfKcalPer100g(int sumOfKcalPer100g) {
        this.sumOfKcalPer100g = sumOfKcalPer100g;
    }

    public double getSumOfFatPer100g() {
        return sumOfFatPer100g;
    }

    public void setSumOfFatPer100g(double sumOfFatPer100g) {
        this.sumOfFatPer100g = sumOfFatPer100g;
    }

    public double getSumOfCarbohydratesPer100g() {
        return sumOfCarbohydratesPer100g;
    }

    public void setSumOfCarbohydratesPer100g(double sumOfCarbohydratesPer100g) {
        this.sumOfCarbohydratesPer100g = sumOfCarbohydratesPer100g;
    }

    public double getSumOfProteinPer100g() {
        return sumOfProteinPer100g;
    }

    public void setSumOfProteinPer100g(double sumOfProteinPer100g) {
        this.sumOfProteinPer100g = sumOfProteinPer100g;
    }

    public List<ProductData> getProductsDataList() {
        return productsDataList;
    }

    public void setProductsDataList(List<ProductData> productsDataList) {
        this.productsDataList = productsDataList;
    }
}
