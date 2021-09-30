package com.infoshare;

public class DummyUser {
    private String name;
    private int age;
    private DummyDish favoriteDish;

    public DummyUser() {
        this.name = "aaa";
        this.age = 22;
        this.favoriteDish = new DummyDish();
    }
}