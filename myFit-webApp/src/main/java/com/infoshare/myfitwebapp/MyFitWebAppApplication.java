package com.infoshare.myfitwebapp;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.infoshare.myfitwebapp.model.UserLogin;
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
    CommandLineRunner runner(UserService userService){
        return args -> {
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<UserLogin>> typeReference = new TypeReference<>(){};
            InputStream inputStream = TypeReference.class.getClassLoader().getResourceAsStream("loginData.json");
            try{
                List<UserLogin> users = mapper.readValue(inputStream, typeReference);
                userService.save(users);
                System.out.println("User login data loaded!");
            } catch (IOException e){
                System.out.println("Unable to save login info: " + e.getMessage());
            }
        };
    }
}
