package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.repository.ProductDataRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.List;

@Service
public class ProductService {
    final
    ProductDataRepository productDataRepository;

    public ProductService(ProductDataRepository productDataRepository) {
        this.productDataRepository = productDataRepository;
    }

    public ProductData save(ProductData product) {
        return productDataRepository.save(product);
    }

    public Iterable<ProductData> save(List<ProductData> products) {
        return productDataRepository.saveAll(products);
    }

    public void saveProductDatabaseToFile(){
        List<ProductData> list = productDataRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("myFit-webApp/src/main/resources/productsData.json");
            gson.toJson(list, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
