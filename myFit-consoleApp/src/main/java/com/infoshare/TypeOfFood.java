package com.infoshare;

public enum TypeOfFood {
    DRINKS("Drinks"),
    FATSANDOILS("Fats & Oils"),
    MEAT("Meat"),
    FRUITS("Fruits"),
    SEEDSANDNUTS("Seeds & Nuts"),
    CEREALPRODUCTS("Cereal Products"),
    OTHER("Other"),
    DAIRYANDEGGPRODUCTS("Dairy & Egg Products"),
    SPICESANDHERBS("Spices & Herbs"),
    VEGETABLES("Vegetables");

    private final String typeOfFood;

    TypeOfFood(String typeOfFood) {
        this.typeOfFood = typeOfFood;
    }

    @Override
    public String toString() {
        return typeOfFood;
    }
}

