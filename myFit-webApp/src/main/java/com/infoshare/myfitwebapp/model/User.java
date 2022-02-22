package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PositiveOrZero;
import java.time.LocalDate;
import java.time.Period;

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
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Column
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate birthDate;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private int height;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weight;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfJobActivity;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ActivityLevel levelOfPrivateActivity;

    @Column(nullable = false)
    @PositiveOrZero(message = "{message.positiveOrZero}")
    private double weightGoal;

    @Column(nullable = false)
    private double basalMetabolicRate;

    @Column(nullable = false)
    private double completeMetabolism;

    public int calculateAge() {
        LocalDate today = LocalDate.now();
        return Period.between(birthDate, today).getYears();
    }
}