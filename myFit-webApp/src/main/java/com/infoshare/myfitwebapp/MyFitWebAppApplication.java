package com.infoshare.myfitwebapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.myfitwebapp.model.DishData;
import com.infoshare.myfitwebapp.model.ProductData;
import com.infoshare.myfitwebapp.model.UserLogin;
import com.infoshare.myfitwebapp.service.DishService;
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
    CommandLineRunner runner(UserService userService, ProductService productService, DishService dishService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserLogin>> userLoginTypeReference = new TypeReference<>(){};
            TypeReference<List<ProductData>> productTypeReference = new TypeReference<>(){};
            TypeReference<List<DishData>> dishDataTypeReference = new TypeReference<>(){};
            InputStream loginDataInputStream = TypeReference.class.getClassLoader().getResourceAsStream("loginData.json");
            InputStream productInputStream = TypeReference.class.getClassLoader().getResourceAsStream("productsData.json");
            InputStream dishDataInputStream = TypeReference.class.getClassLoader().getResourceAsStream("dishData.json");
            try{
                List<UserLogin> users = mapper.readValue(loginDataInputStream, userLoginTypeReference);
                userService.save(users);
                System.out.println("User login data loaded!");
                List<ProductData> products = mapper.readValue(productInputStream, productTypeReference);
                productService.save(products);
                System.out.println("Product data loaded!");
                List<DishData> dishes = mapper.readValue(dishDataInputStream, dishDataTypeReference);
                dishService.save(dishes);
                System.out.println("Dish data loaded!");
            } catch (IOException e){
                System.out.println("Unable to save data to json file: " + e.getMessage());
            }
        };
    }
}
