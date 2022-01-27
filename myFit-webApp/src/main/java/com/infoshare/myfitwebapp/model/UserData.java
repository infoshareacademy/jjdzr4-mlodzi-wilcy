package com.infoshare.myfitwebapp.model;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Data
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Setter(AccessLevel.NONE)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String gender;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false)
    private int height;
    @Column(nullable = false)
    private double weight;
    @Column(nullable = false)
    private String levelOfJobActivity;
    @Column(nullable = false)
    private String levelOfPrivateActivity;
    @Column(nullable = false)
    private double weightGoal;
    @Column(nullable = false)
    private double ppm;
    @Column(nullable = false)
    private double cpm;
}