package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.entity.Dish;
import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.DishDataRepository;
import com.infoshare.myfitwebapp.repository.ProductDataRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DishService {
    final DishDataRepository dishDataRepository;
    final ProductDataRepository productDataRepository;

    public DishService(DishDataRepository dishDataRepository, ProductDataRepository productDataRepository) {
        this.dishDataRepository = dishDataRepository;
        this.productDataRepository = productDataRepository;
    }

    public Dish save(Dish dish) {
        return dishDataRepository.save(dish);
    }

    public Iterable<Dish> save(List<Dish> dish) {
        return dishDataRepository.saveAll(dish);
    }

    public List<Dish> findAll() {
        return dishDataRepository.findAll();
    }

    public List<Dish> findByName(String name) {
        return dishDataRepository.findByName(name);
    }

    public Dish createDish(String dishName, List<String> productNames) {
        List<Product> productList = productNames.stream().map(productDataRepository::findByName).flatMap(Collection::stream).collect(Collectors.toList());
        Dish dish = new Dish();
        dish.setName(dishName);
        dish.setProductsNameList(productNames);
        dish.setSumOfKcalPer100g(calculateSumOfKcalPer100g(productList));
        dish.setSumOfFatPer100g(calculateSumOfFatPer100g(productList));
        dish.setSumOfCarbohydratesPer100g(calculateSumOfCarbohydratesPer100g(productList));
        dish.setSumOfProteinPer100g(calculateSumOfProteinPer100g(productList));
        return dish;
    }

    private int calculateSumOfKcalPer100g(List<Product> products) {
        int sumOfKcalPer100g = 0;
        for (Product p : products) {
            sumOfKcalPer100g += p.getKcalPer100g();
        }
        return sumOfKcalPer100g;
    }

    private double calculateSumOfFatPer100g(List<Product> products) {
        double sumOfFatPer100g = 0.0;
        for (Product p : products) {
            sumOfFatPer100g += p.getFatPer100g();
        }
        return sumOfFatPer100g;
    }

    private double calculateSumOfCarbohydratesPer100g(List<Product> products) {
        double sumOfCarbohydratesPer100g = 0.0;
        for (Product p : products) {
            sumOfCarbohydratesPer100g += p.getCarbohydratesPer100g();
        }
        return sumOfCarbohydratesPer100g;
    }

    private double calculateSumOfProteinPer100g(List<Product> products) {
        double sumOfProteinPer100g = 0.0;
        for (Product p : products) {
            sumOfProteinPer100g += p.getProteinPer100g();
        }
        return sumOfProteinPer100g;
    }

    public void saveDishDatabaseToFile() {
        List<Dish> list = dishDataRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("myFit-webApp/src/main/resources/dishData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}