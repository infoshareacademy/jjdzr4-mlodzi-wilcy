package com.infoshare.myfitwebapp.service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.dto.ProductDto;
import com.infoshare.myfitwebapp.repository.ProductRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;

    public ProductService(ProductRepository productRepository, ModelMapper modelMapper) {
        this.productRepository = productRepository;
        this.modelMapper = modelMapper;
    }

//    TODO - All methods shoudl operate on DTO
    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Iterable<Product> save(List<Product> products) {
        return productRepository.saveAll(products);
    }

    public List<ProductDto> findAllProducts() {
        List<Product> allProducts = productRepository.findAll();
        return allProducts.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    public List<ProductDto> findProductsByName(String name){
        List<Product> productByName = productRepository.findByName(name);
        return productByName.stream()
                .map(product -> modelMapper.map(product, ProductDto.class))
                .collect(Collectors.toList());
    }

    @Transactional
    public ProductDto findProductById(Long id){
        Optional<Product> productById = productRepository.findById(id);
        if(productById.isPresent()) {
            Product product = productById.get();
            return modelMapper.map(product, ProductDto.class);
        }
        return null;
    }

    @Transactional
    public ProductDto updateProduct(ProductDto dto) {
        Optional<Product> byId = productRepository.findById(dto.getId());
        if (byId.isPresent()) {
            Product product = byId.get();
            modelMapper.map(dto, product);
            Product persistedEntity = productRepository.save(product);
            //TODO - merge save to file with save
            saveProductDatabaseToFile();
            return modelMapper.map(persistedEntity, ProductDto.class);
        }
        return null;
    }

    public void saveProductDatabaseToFile() {
        List<Product> products = productRepository.findAll();
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try {
            Writer fileWriter = new FileWriter("myFit-webApp/src/main/resources/productsData.json");
            gson.toJson(products, fileWriter);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
