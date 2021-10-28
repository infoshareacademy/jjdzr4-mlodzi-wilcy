package com.infoshare;

public enum TypeOfFood {
    DRINKS("Drinks"),
    FATSANDOILS("Fats & Oils"),
    MEAT("Meat"),
    FRUITS("Fruits"),
    SEEDSANDNUTS("Seeds & Nut"),
    CEREALPRODUCTS("Cereal Products"),
    OTHER("Other"),
    DAIRYANDEGGPRODUCTS("Dairy & Egg Products"),
    SPICESANDHERBS("Spices & Herbs"),
    VEGETABLES("Vegetables");

 private final String type;

 TypeOfFood (String type) {
     this.type = type;
 }

    @Override
    public String toString() {
        return type;
    }

}