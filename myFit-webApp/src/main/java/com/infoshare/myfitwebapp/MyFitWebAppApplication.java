package com.infoshare.myfitwebapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.myfitwebapp.entity.Dish;
import com.infoshare.myfitwebapp.entity.Product;
import com.infoshare.myfitwebapp.entity.UserLogin;
import com.infoshare.myfitwebapp.service.DishService;
import com.infoshare.myfitwebapp.service.ProductService;
import com.infoshare.myfitwebapp.service.UserService;
import com.infoshare.myfitwebapp.util.JsonMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@SpringBootApplication
public class MyFitWebAppApplication {

    private static final Logger LOGGER = LogManager.getLogger(MyFitWebAppApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(MyFitWebAppApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(UserService userService, ProductService productService, DishService dishService){
        return args -> {
                LOGGER.info("Dish data loaded!");
        };
    }
}
