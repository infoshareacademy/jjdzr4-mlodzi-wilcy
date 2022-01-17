package com.infoshare.myfitwebapp.model;

import javax.persistence.*;

@Entity
public class UserData {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getLevelOfJobActivity() {
        return levelOfJobActivity;
    }

    public void setLevelOfJobActivity(String levelOfJobActivity) {
        this.levelOfJobActivity = levelOfJobActivity;
    }

    public String getLevelOfPrivateActivity() {
        return levelOfPrivateActivity;
    }

    public void setLevelOfPrivateActivity(String levelOfPrivateActivity) {
        this.levelOfPrivateActivity = levelOfPrivateActivity;
    }

    public double getWeightGoal() {
        return weightGoal;
    }

    public void setWeightGoal(double weightGoal) {
        this.weightGoal = weightGoal;
    }

    public double getPpm() {
        return ppm;
    }

    public void setPpm(double PPM) {
        this.ppm = PPM;
    }

    public double getCpm() {
        return cpm;
    }

    public void setCpm(double CPM) {
        this.cpm = CPM;
    }

    public Long getId(){
        return this.id;
    }



}