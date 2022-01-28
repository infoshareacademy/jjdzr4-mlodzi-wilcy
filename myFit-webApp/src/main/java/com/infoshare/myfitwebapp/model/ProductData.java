package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
public class ProductData {

    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";
    private static final String POSITIVE_OR_ZERO_MESSAGE = "Wartość nie może być ujemna";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
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
}
