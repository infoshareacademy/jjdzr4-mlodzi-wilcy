package com.infoshare.myfitwebapp.model;

import java.util.ArrayList;
import java.util.List;

public class DishData {
    private final long id;
    private String dishName;
    private int sumOfKcalPer100g;
    private double sumOfFatPer100g;
    private double sumOfCarbohydratesPer100g;
    private double sumOfProteinPer100g;
    private List<ProductData> productsDataList = new ArrayList<>();

    public DishData(long id, String dishName, int sumOfKcalPer100g, double sumOfFatPer100g, double sumOfCarbohydratesPer100g, double sumOfProteinPer100g, List<ProductData> productsDataList) {
        this.id = id;
        this.dishName = dishName;
        this.sumOfKcalPer100g = sumOfKcalPer100g;
        this.sumOfFatPer100g = sumOfFatPer100g;
        this.sumOfCarbohydratesPer100g = sumOfCarbohydratesPer100g;
        this.sumOfProteinPer100g = sumOfProteinPer100g;
        this.productsDataList = productsDataList;
    }
}
