package com.infoshare.Utils;

import com.infoshare.ProductsDataBase;

import java.util.List;

public class FoodDataBase {

    private static final String FOOD_DATA_PATH = "src/main/resources/foodData.json";
    private static FoodDataBase INSTANCE;

    private final List<ProductsDataBase> foodData;

    public static FoodDataBase getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new FoodDataBase();
        }
        return INSTANCE;
    }

    private FoodDataBase() {
        this.foodData = FileUtils.readListFromJsonFile(FOOD_DATA_PATH);
    }

    public void add(ProductsDataBase productsDataBase) {
        foodData.add(productsDataBase);
    }


    public void saveProductsDataBaseToFile() {
        FileUtils.writeListToJsonFile(FOOD_DATA_PATH, foodData);
    }
}