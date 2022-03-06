package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.dto.DishDto;
import com.infoshare.myfitwebapp.dto.ProductDto;
import com.infoshare.myfitwebapp.entity.Dish;
import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.repository.DishDataRepository;
import com.infoshare.myfitwebapp.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DishService {
    private final DishDataRepository dishDataRepository;
    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public DishService(DishDataRepository dishDataRepository, ProductRepository productRepository, ModelMapper modelMapper) {
        this.dishDataRepository = dishDataRepository;
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

    public Dish save(Dish dish) {
        return dishDataRepository.save(dish);
    }

    public Iterable<Dish> save(List<Dish> dish) {
        return dishDataRepository.saveAll(dish);
    }

    public List<DishDto> findAll() {
        List<Dish> allDishes = dishDataRepository.findAll();
        return allDishes.stream()
                .map(dish -> modelMapper.map(dish, DishDto.class))
                .collect(Collectors.toList());
    }

    public List<DishDto> findByName(String name) {
        List<Dish> dishListByName = dishDataRepository.findByName(name);
        return dishListByName.stream()
                .map(dish -> modelMapper.map(dish, DishDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public DishDto findById(Long id) {
        Optional<Dish> byId = dishDataRepository.findById(id);
        if(byId.isPresent()) {
            Dish dish = byId.get();
            return modelMapper.map(dish, DishDto.class);
        }
        return null;
    }

    @Transactional
    public DishDto update(DishDto dto){
        Optional<Dish> byId = dishDataRepository.findById(dto.getId());
        if(byId.isPresent()) {
            Dish dish = byId.get();
            modelMapper.map(dto, dish);
            Dish persistedEntity = dishDataRepository.save(dish);
            //TODO - merge save to file with save
            saveDatabaseToFile();
            return modelMapper.map(persistedEntity, DishDto.class);
        }
        return null;
    }

    @Transactional
    public Dish create(String dishName, List<ProductDto> dtos) {
        List<Product> productList = dtos.stream()
                .map(modelMapper.map(dtos, Product.class))
                .collect(Collectors.toList());
        Dish dish = new Dish();
        dish.setName(dishName);
        dish.setProductsNameList(dtos.stream().map());
        dish.setSumOfKcalPer100g(calculateSumOfKcalPer100g(productList));
        dish.setSumOfFatPer100g(calculateSumOfFatPer100g(productList));
        dish.setSumOfCarbohydratesPer100g(calculateSumOfCarbohydratesPer100g(productList));
        dish.setSumOfProteinPer100g(calculateSumOfProteinPer100g(productList));
        save(dish);
        return dish;
    }

    // FIXME - Where is taken into account quantity of each product ?!?!
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

    public void saveDatabaseToFile() {
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