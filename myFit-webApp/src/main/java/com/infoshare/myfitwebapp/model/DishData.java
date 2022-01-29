package com.infoshare.myfitwebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public class DishData {
    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Column(nullable = false)
    private String name;
    @Column(nullable = true)
    private int sumOfKcalPer100g;
    @Column(nullable = true)
    private double sumOfFatPer100g;
    @Column(nullable = true)
    private double sumOfCarbohydratesPer100g;
    @Column(nullable = true)
    private double sumOfProteinPer100g;
    @ElementCollection
    private List<String> productsNameList = new ArrayList<>();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String dishName) {
        this.name = dishName;
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

    public List<String> getProductsNameList() {
        return productsNameList;
    }

    public void setProductsNameList(List<String> productsNameList) {
        this.productsNameList = productsNameList;
    }
}
