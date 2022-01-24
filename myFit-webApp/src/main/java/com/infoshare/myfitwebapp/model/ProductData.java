package com.infoshare.myfitwebapp.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
public class ProductData {

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";
    private static final String POSITIVE_OR_ZERO_MESSAGE = "Wartość nie może być ujemna";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Column(nullable = false)
    private String name;
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Column(nullable = false)
    private int kcalPer100g;
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Column(nullable = false)
    private double fatPer100g;
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Column(nullable = false)
    private double carbohydratesPer100g;
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Column(nullable = false)
    private double proteinPer100g;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
