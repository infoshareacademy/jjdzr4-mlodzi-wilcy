package com.infoshare.myfitwebapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.service.ProductService;
import com.infoshare.myfitwebapp.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MyFitWebAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyFitWebAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService, ProductService productService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserLogin>> typeReference = new TypeReference<>(){};
            TypeReference<List<ProductData>> productTypeReference = new TypeReference<>(){};
            InputStream inputStream = TypeReference.class.getClassLoader().getResourceAsStream("loginData.json");
            InputStream productInputStream = TypeReference.class.getClassLoader().getResourceAsStream("productsData.json");
            try{
                List<ProductData> products = mapper.readValue(productInputStream, productTypeReference);
                List<UserLogin> users = mapper.readValue(inputStream, typeReference);
                userService.save(users);
                productService.save(products);
                System.out.println("User login data and product data loaded!");
            } catch (IOException e){
                System.out.println("Unable to save login info: " + e.getMessage());
            }
        };
    }
}
