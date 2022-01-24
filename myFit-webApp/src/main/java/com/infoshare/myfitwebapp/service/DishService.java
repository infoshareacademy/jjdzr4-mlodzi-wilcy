package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.DishData;
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

    public void saveDishDatabaseToFile(){
        List<DishData> list = dishDataRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("myFit-webApp/src/main/resources/dishData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}