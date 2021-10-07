package com.infoshare;

import java.util.Objects;

public class InfoUser {
    private String name;
    private String sex;
    private int age;
    private int hight;
    private double weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int hight) {
        this.hight = hight;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InfoUser infoUser = (InfoUser) o;
        return age == infoUser.age && hight == infoUser.hight && Double.compare(infoUser.weight, weight) == 0 && name.equals(infoUser.name) && sex.equals(infoUser.sex);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, hight, weight);
    }

    @Override
    public String toString() {
        return "InfoUser{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", hight=" + hight +
                ", weight=" + weight +
                '}';
    }

    public InfoUser(String name, String sex, int age, int hight, double weight) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.hight = hight;
        this.weight = weight;


    }
}
