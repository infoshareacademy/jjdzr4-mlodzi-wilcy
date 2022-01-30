package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Entity
public @Data
class Dish {
    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private int sumOfKcalPer100g;
    @Column(nullable = false)
    private double sumOfFatPer100g;
    @Column(nullable = false)
    private double sumOfCarbohydratesPer100g;
    @Column(nullable = false)
    private double sumOfProteinPer100g;
    @ElementCollection
    private List<String> productsNameList = new ArrayList<>();
}
