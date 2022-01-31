package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Data
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "{message.notEmpty}")
    private String name;

    @Column(nullable = false)
    private String gender;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private int age;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private int height;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weight;

    @Column(nullable = false)
    private String levelOfJobActivity;

    @Column(nullable = false)
    private String levelOfPrivateActivity;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weightGoal;

    @Column(nullable = false)
    private double basalMetabolicRate;

    @Column(nullable = false)
    private double completeMetabolism;
}