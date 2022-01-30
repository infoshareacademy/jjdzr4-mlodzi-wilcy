package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.model.Product;
import com.infoshare.myfitwebapp.model.ProductDto;
import com.infoshare.myfitwebapp.repository.ProductDataRepository;
import org.springframework.stereotype.Service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    final
    ProductDataRepository productDataRepository;

    public ProductService(ProductDataRepository productDataRepository) {
        this.productDataRepository = productDataRepository;
    }

    public Product save(Product product) {
        return productDataRepository.save(product);
    }

    public Iterable<Product> save(List<Product> products) {
        return productDataRepository.saveAll(products);
    }

    public List<ProductDto> getProductDtos() {
        List<ProductDto> productDtoList = new ArrayList<>();
        productDataRepository.findAll().stream().forEach(
                productData -> {
                    productDtoList.add(new ProductDto(productData.getId(), productData.getName()));
                }
        );
        return productDtoList;
    }

    public void saveProductDatabaseToFile(){
        List<Product> list = productDataRepository.findAll();
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
