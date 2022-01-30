package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
public class Product {

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";
    private static final String POSITIVE_OR_ZERO_MESSAGE = "Wartość nie może być ujemna";
    private static final String MAX_100_MESSAGE = "Wartość nie może być większa niż 100";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @NotBlank(message = NOT_EMPTY_MESSAGE)
    @Column(nullable = false)
    private String name;

    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Max(value = 100, message = MAX_100_MESSAGE)
    @Column(nullable = false)
    private int kcalPer100g;

    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Max(value = 100, message = MAX_100_MESSAGE)
    @Column(nullable = false)
    private double fatPer100g;

    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Max(value = 100, message = MAX_100_MESSAGE)
    @Column(nullable = false)
    private double carbohydratesPer100g;

    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    @Max(value = 100, message = MAX_100_MESSAGE)
    @Column(nullable = false)
    private double proteinPer100g;


}
