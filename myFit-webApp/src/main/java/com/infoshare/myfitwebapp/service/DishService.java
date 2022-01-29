package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.DishData;
import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.repository.DishDataRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class DishService {
    final
    DishDataRepository dishDataRepository;

    public DishService(DishDataRepository dishDataRepository) {
        this.dishDataRepository = dishDataRepository;
    }

    public DishData save(DishData dish) {
        return dishDataRepository.save(dish);
    }

    public Iterable<DishData> save(List<DishData> dish) {
        return dishDataRepository.saveAll(dish);
    }

    public List<DishData> findAll() {
        return dishDataRepository.findAll();
    }

    public List<DishData> findByName(String name) {
        return dishDataRepository.findByName(name);
    }

    public DishData createDish(String dishName, List<String> productNames) {
        DishData dishData = new DishData();
        dishData.setId(123);
        dishData.setName(dishName);
        dishData.setProductsNameList(productNames);
        return dishData;
    }

    private int calculateSumOfKcalPer100g(List<ProductData> productDataList) {
        int temporarySumOfKcalPer100g = 0;
        for (ProductData p : productDataList) {
            temporarySumOfKcalPer100g += p.getKcalPer100g();
        }
        return temporarySumOfKcalPer100g;
    }

    private double calculateSumOfFatPer100g(List<ProductData> productDataList) {
        double temporarySumOfFatPer100g = 0.0;
        for (ProductData p : productDataList) {
            temporarySumOfFatPer100g += p.getFatPer100g();
        }
        return temporarySumOfFatPer100g;
    }

    private double calculateSumOfCarbohydratesPer100g(List<ProductData> productDataList) {
        double temporarySumOfCarbohydratesPer100g = 0.0;
        for (ProductData p : productDataList) {
            temporarySumOfCarbohydratesPer100g += p.getCarbohydratesPer100g();
        }
        return temporarySumOfCarbohydratesPer100g;
    }

    private double calculateSumOfProteinPer100g(List<ProductData> productDataList) {
        double temporarySumOfProteinPer100g = 0.0;
        for (ProductData p : productDataList) {
            temporarySumOfProteinPer100g += p.getProteinPer100g();
        }
        return temporarySumOfProteinPer100g;
    }

    public void saveDishDatabaseToFile() {
        List<DishData> list = dishDataRepository.findAll();
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