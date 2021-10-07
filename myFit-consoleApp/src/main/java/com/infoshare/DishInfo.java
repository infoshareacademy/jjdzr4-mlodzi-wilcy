package com.infoshare;

import java.util.Objects;

public class DishInfo {
    private String name;
    private InfoProduct infoProduct;

    public DishInfo(String name, InfoProduct infoProduct) {
        this.name = name;
        this.infoProduct = infoProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DishInfo dishInfo = (DishInfo) o;
        return name.equals(dishInfo.name) && infoProduct.equals(dishInfo.infoProduct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, infoProduct);
    }

    public InfoProduct getInfoProduct() {
        return infoProduct;
    }

    public void setInfoProduct(InfoProduct infoProduct) {
        this.infoProduct = infoProduct;
    }

    @Override
    public String toString() {
        return "DishInfo{" +
                "name='" + name + '\'' +
                ", infoProduct=" + infoProduct +
                '}';
    }
}
