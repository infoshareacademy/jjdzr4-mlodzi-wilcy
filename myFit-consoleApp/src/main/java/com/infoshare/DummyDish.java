package com.infoshare;

public class DummyDish {
    private String name;
    private int kcal;

    public DummyDish() {
        this.name = "dish";
        this.kcal = 111;
    }

    @Override
    public String toString() {
        return "DummyDish{" +
                "name='" + name + '\'' +
                ", kcal=" + kcal +
                '}';
    }
}