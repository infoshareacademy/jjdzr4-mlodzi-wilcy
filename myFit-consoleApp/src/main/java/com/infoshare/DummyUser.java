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

    @Override
    public String toString() {
        return "DummyUser{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", favoriteDish=" + favoriteDish +
                '}';
    }
}