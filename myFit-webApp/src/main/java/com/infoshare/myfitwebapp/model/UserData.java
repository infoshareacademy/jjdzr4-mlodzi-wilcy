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
public class UserData {
    private static final String NOT_EMPTY_MESSAGE = "Pole nie może być puste";
    private static final String POSITIVE_OR_ZERO_MESSAGE = "Wartość nie może być ujemna";

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false)
    @NotEmpty(message = NOT_EMPTY_MESSAGE)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    private int age;
    @Column(nullable = false)
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    private int height;
    @Column(nullable = false)
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    private double weight;
    @Column(nullable = false)
    private String levelOfJobActivity;
    @Column(nullable = false)
    private String levelOfPrivateActivity;
    @Column(nullable = false)
    @PositiveOrZero(message = POSITIVE_OR_ZERO_MESSAGE)
    private double weightGoal;
    @Column(nullable = false)
    private double ppm;
    @Column(nullable = false)
    private double cpm;
}