package com.infoshare.myfitwebapp.model;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data
class DishData {
    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Getter
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
}
